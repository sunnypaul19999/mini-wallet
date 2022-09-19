package com.helios.miniwallet.model.walletransaction;

import com.helios.miniwallet.model.wallet.Wallet;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "wallet_transaction_history")
public class WalletTransactionHistory {

  @Id
  @Column(name = "wallet_transaction_id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final long id;

  @Version
  @Column(name = "wallet_transaction_timestamp", nullable = false)
  private final Timestamp walletTransactionTimestamp;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "wallet_transaction_action", nullable = false, updatable = false)
  private final WalletTransactionAction action;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "wallet_id",
      referencedColumnName = "wallet_id",
      nullable = false,
      updatable = false)
  private Wallet wallet;

  public WalletTransactionHistory(
      long id, Timestamp walletTransactionTimestamp, WalletTransactionAction action) {

    this.id = id;
    this.walletTransactionTimestamp = walletTransactionTimestamp;
    this.action = action;
  }

  public long getId() {

    return id;
  }

  public Timestamp getWalletTransactionTimestamp() {

    return walletTransactionTimestamp;
  }

  public WalletTransactionAction getAction() {

    return action;
  }

  public Wallet getWallet() {

    return wallet;
  }

  public void setWallet(Wallet wallet) {

    this.wallet = wallet;
  }
}
