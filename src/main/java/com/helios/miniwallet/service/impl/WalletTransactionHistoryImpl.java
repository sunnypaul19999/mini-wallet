package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.model.wallet.Wallet;
import com.helios.miniwallet.model.walletransaction.WalletTransactionAction;
import com.helios.miniwallet.model.walletransaction.WalletTransactionHistory;
import com.helios.miniwallet.repository.WalletTransactionHistoryRepo;
import com.helios.miniwallet.service.WalletTransactionHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletTransactionHistoryImpl implements WalletTransactionHistoryService {

  private final WalletTransactionHistoryRepo walletTransactionHistoryRepo;

  public WalletTransactionHistoryImpl(WalletTransactionHistoryRepo walletTransactionHistoryRepo) {

    this.walletTransactionHistoryRepo = walletTransactionHistoryRepo;
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

  public List<WalletTransactionHistory> getTransactionHistory(Wallet wallet) {

    return walletTransactionHistoryRepo.findByWalletWalletId(wallet.getWalletId());
  }
}
