package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.dto.request.MiniWalletRequestCredit;
import com.helios.miniwallet.dto.request.MiniWalletRequestDebit;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.wallet.Wallet;
import com.helios.miniwallet.repository.WalletRepo;
import com.helios.miniwallet.service.UserService;
import com.helios.miniwallet.service.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

  private final UserService userService;

  private final WalletRepo walletRepo;

  WalletServiceImpl(UserService userService, WalletRepo walletRepo) {

    this.userService = userService;
    this.walletRepo = walletRepo;
  }

  @Transactional(propagation = Propagation.REQUIRED)
  private Optional<Wallet> getWallet(String username) throws MiniWalletUserNotFoundException {

    User user = userService.findUser(username);

    return walletRepo.findByUserUserId(user.getUserId());
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

    return getWallet(username).get().getAvailableBalance();
  }

  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
  public void debitAmt(MiniWalletRequestDebit debitRequest) throws MiniWalletUserNotFoundException {

    Wallet wallet = getWallet(debitRequest.getUsername()).get();

    wallet.setAvailableBalance(wallet.getAvailableBalance() - debitRequest.getAmt());

    walletRepo.save(wallet);
  }

  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
  public void creditAmt(MiniWalletRequestCredit creditRequest)
      throws MiniWalletUserNotFoundException {

    Wallet wallet = getWallet(creditRequest.getUsername()).get();

    wallet.setAvailableBalance(wallet.getAvailableBalance() + creditRequest.getAmt());

    walletRepo.save(wallet);
  }
}
