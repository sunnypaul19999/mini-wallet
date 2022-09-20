package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.model.wallet.Wallet;
import com.helios.miniwallet.model.walletransaction.WalletTransactionAction;
import com.helios.miniwallet.model.walletransaction.WalletTransactionHistory;
import com.helios.miniwallet.repository.WalletTransactionHistoryRepo;
import com.helios.miniwallet.service.WalletService;
import com.helios.miniwallet.service.WalletTransactionHistoryService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletTransactionHistoryImpl implements WalletTransactionHistoryService {

  private final WalletTransactionHistoryRepo walletTransactionHistoryRepo;

  private final WalletService walletService;

  public WalletTransactionHistoryImpl(
      WalletTransactionHistoryRepo walletTransactionHistoryRepo, WalletService walletService) {

    this.walletTransactionHistoryRepo = walletTransactionHistoryRepo;
    this.walletService = walletService;
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public void createTransaction(
      Wallet wallet, long transactionAmount, WalletTransactionAction transactionAction) {

    WalletTransactionHistory walletTransaction = new WalletTransactionHistory();

    if (transactionAction == WalletTransactionAction.DEBIT) {

      walletTransaction.setAction(WalletTransactionAction.DEBIT);
    } else if (transactionAction == WalletTransactionAction.CREDIT) {

      walletTransaction.setAction(WalletTransactionAction.CREDIT);
    } else {

      // a future reminder if there is any change in transaction action,
      // and I forgot make change here
      throw new RuntimeException("Unknown WalletTransactionAction");
    }

    walletTransaction.setWalletTransactionAmount(transactionAmount);

    walletTransaction.setWalletTransactionBalance(wallet.getAvailableBalance());

    walletTransaction.setWallet(wallet);

    walletTransactionHistoryRepo.save(walletTransaction);
  }

  public List<WalletTransactionHistory> getTransactionHistory(String username)
      throws MiniWalletUserNotFoundException {

    Wallet wallet = walletService.getWallet(username);

    return walletTransactionHistoryRepo.findByWalletWalletId(
        wallet.getWalletId(), Sort.by(Sort.Order.desc("walletTransactionTimestamp")));
  }
}
