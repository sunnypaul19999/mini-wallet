package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.dto.request.MiniWalletRequestCredit;
import com.helios.miniwallet.dto.request.MiniWalletRequestDebit;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.exception.wallet.MiniWalletInvalidTransactionAmountException;
import com.helios.miniwallet.exception.wallet.MiniWalletMinimumBalanceException;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.wallet.Wallet;
import com.helios.miniwallet.model.walletransaction.WalletTransactionAction;
import com.helios.miniwallet.repository.WalletRepo;
import com.helios.miniwallet.service.UserService;
import com.helios.miniwallet.service.WalletService;
import com.helios.miniwallet.service.WalletTransactionHistoryService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class WalletServiceImpl implements WalletService {

  private final UserService userService;

  private final WalletRepo walletRepo;

  private final WalletTransactionHistoryService walletTransactionHistoryService;

  WalletServiceImpl(
      UserService userService,
      WalletRepo walletRepo,
      @Lazy WalletTransactionHistoryService walletTransactionHistoryService) {

    this.userService = userService;
    this.walletRepo = walletRepo;
    this.walletTransactionHistoryService = walletTransactionHistoryService;
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public Wallet getWallet(String username) throws MiniWalletUserNotFoundException {

    User user = userService.findUser(username);

    return walletRepo.findByUserUserId(user.getUserId()).get();
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY)
  public Wallet createNewWallet(User user) {

    Wallet wallet = new Wallet(user, 0);

    wallet = walletRepo.save(wallet);

    return wallet;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public long availableBalance(String username) throws MiniWalletUserNotFoundException {

    return getWallet(username).getAvailableBalance();
  }

  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
  public Wallet debitAmt(MiniWalletRequestDebit debitRequest)
      throws MiniWalletUserNotFoundException, MiniWalletInvalidTransactionAmountException,
          MiniWalletMinimumBalanceException {

    Wallet wallet = getWallet(debitRequest.getUsername());

    long onDebitBalance = wallet.getAvailableBalance() - debitRequest.getAmt();

    if (debitRequest.getAmt() > 0) {

      if (onDebitBalance > 0) {

        wallet.setAvailableBalance(onDebitBalance);
      } else {

        throw new MiniWalletMinimumBalanceException("Wallet does not have required balance");
      }
    } else {

      throw new MiniWalletInvalidTransactionAmountException(
          debitRequest.getAmt(), new Date().getTime(), "Amount should be greater than 0");
    }

    wallet = walletRepo.save(wallet);

    walletTransactionHistoryService.createTransaction(
        wallet, debitRequest.getAmt(), WalletTransactionAction.DEBIT);

    return wallet;
  }

  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
  public Wallet creditAmt(MiniWalletRequestCredit creditRequest)
      throws MiniWalletUserNotFoundException {

    Wallet wallet = getWallet(creditRequest.getUsername());

    wallet.setAvailableBalance(wallet.getAvailableBalance() + creditRequest.getAmt());

    wallet = walletRepo.save(wallet);

    walletTransactionHistoryService.createTransaction(
        wallet, creditRequest.getAmt(), WalletTransactionAction.CREDIT);

    return wallet;
  }
}
