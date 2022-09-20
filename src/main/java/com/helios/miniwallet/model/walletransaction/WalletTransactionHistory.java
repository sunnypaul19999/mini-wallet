package com.helios.miniwallet.model.walletransaction;

import com.helios.miniwallet.model.wallet.Wallet;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "wallet_transaction_history")
public class WalletTransactionHistory {

  @Id
  @Column(name = "wallet_transaction_id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "wallet_transaction_action", nullable = false, updatable = false)
  private WalletTransactionAction action;

  @Version
  @Column(name = "wallet_transaction_timestamp", nullable = false)
  private Timestamp walletTransactionTimestamp;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "wallet_id",
      referencedColumnName = "wallet_id",
      nullable = false,
      updatable = false)
  private Wallet wallet;

  public WalletTransactionHistory() {}

  public long getId() {

    return id;
  }

  public void setId(long id) {

    this.id = id;
  }

  public WalletTransactionAction getAction() {

    return action;
  }

  public void setAction(WalletTransactionAction action) {

    this.action = action;
  }

  public Timestamp getWalletTransactionTimestamp() {

    return walletTransactionTimestamp;
  }

  public void setWalletTransactionTimestamp(Timestamp walletTransactionTimestamp) {

    this.walletTransactionTimestamp = walletTransactionTimestamp;
  }

  public Wallet getWallet() {

    return wallet;
  }

  public void setWallet(Wallet wallet) {

    this.wallet = wallet;
  }

  @Override
  public String toString() {

    return "WalletTransactionHistory{"
        + "id="
        + id
        + ", action="
        + action
        + ", walletTransactionTimestamp="
        + walletTransactionTimestamp
        + '}';
  }
}
