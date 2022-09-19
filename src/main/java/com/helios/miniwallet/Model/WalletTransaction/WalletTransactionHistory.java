package com.helios.miniwallet.Model.WalletTransaction;

import com.helios.miniwallet.Model.Wallet.Wallet;

import javax.persistence.*;

@Entity(name = "wallet_transaction_history")
public class WalletTransactionHistory {

  @Id
  @Column(name = "wallet_transaction_id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final long id;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "wallet_transaction_action", nullable = false, updatable = false)
  private final WalletTransactionAction action;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", nullable = false, updatable = false)
  private Wallet wallet;

  public WalletTransactionHistory(long id, WalletTransactionAction action) {

    this.id = id;
    this.action = action;
  }

  public long getId() {

    return id;
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
