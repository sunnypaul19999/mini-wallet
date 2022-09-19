package com.helios.miniwallet.Model.Wallet;

import com.helios.miniwallet.Model.User.User;
import com.helios.miniwallet.Model.WalletTransaction.WalletTransactionHistory;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "wallet")
public class Wallet {

  @Id
  @Column(name = "walletId", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final long id;

  @Version
  @Column(name = "walletTimestamp", nullable = false)
  private final Timestamp timestamp;

  @Min(value = 0)
  @Column(name = "availableBalance", nullable = false)
  private long availableBalance;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  @OneToMany(mappedBy = "wallet")
  private List<WalletTransactionHistory> transactionHistory;

  public Wallet(long id, Timestamp timestamp) {

    this.id = id;
    this.timestamp = timestamp;
  }

  public long getId() {

    return id;
  }

  public Timestamp getTimestamp() {

    return timestamp;
  }

  public long getAvailableBalance() {

    return availableBalance;
  }

  public void setAvailableBalance(long availableBalance) {

    this.availableBalance = availableBalance;
  }

  public List<WalletTransactionHistory> getTransactionHistory() {

    return transactionHistory;
  }

  public void setTransactionHistory(List<WalletTransactionHistory> transactionHistory) {

    this.transactionHistory = transactionHistory;
  }
}
