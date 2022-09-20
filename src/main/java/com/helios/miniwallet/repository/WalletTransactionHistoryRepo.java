package com.helios.miniwallet.repository;

import com.helios.miniwallet.model.walletransaction.WalletTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionHistoryRepo
    extends JpaRepository<WalletTransactionHistory, Integer> {

  List<WalletTransactionHistory> findByWalletWalletId(long walletId);
}
