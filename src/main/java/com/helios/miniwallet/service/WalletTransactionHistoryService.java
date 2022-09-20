package com.helios.miniwallet.service;

import com.helios.miniwallet.model.wallet.Wallet;
import com.helios.miniwallet.model.walletransaction.WalletTransactionAction;
import com.helios.miniwallet.model.walletransaction.WalletTransactionHistory;

import java.util.List;

public interface WalletTransactionHistoryService {

  void createTransaction(
      Wallet wallet, long transactionAmount, WalletTransactionAction transactionAction);

  List<WalletTransactionHistory> getTransactionHistory(Wallet wallet);
}
