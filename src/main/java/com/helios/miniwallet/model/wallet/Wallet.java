package com.helios.miniwallet.model.wallet;

import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.walletransaction.WalletTransactionHistory;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "wallet")
public class Wallet {

  @Id
  @Column(name = "wallet_id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long walletId;

  @Min(value = 0)
  @Column(name = "available_balance", nullable = false)
  private long availableBalance;

  @Version
  @Column(name = "wallet_timestamp", nullable = false)
  private Timestamp walletTimestamp;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "user_id",
      referencedColumnName = "user_id",
      unique = true,
      nullable = false,
      updatable = false)
  private User user;

  @OneToMany(mappedBy = "wallet", cascade = CascadeType.REMOVE)
  private List<WalletTransactionHistory> transactionHistory;

  public Wallet() {}

  public Wallet(User user, long availableBalance) {

    this.user = user;
    this.availableBalance = availableBalance;
  }

  public long getWalletId() {

    return walletId;
  }

  public void setWalletId(long walletId) {

    this.walletId = walletId;
  }

  public long getAvailableBalance() {

    return availableBalance;
  }

  public void setAvailableBalance(long availableBalance) {

    this.availableBalance = availableBalance;
  }

  public Timestamp getWalletTimestamp() {

    return walletTimestamp;
  }

  public void setWalletTimestamp(Timestamp walletTimestamp) {

    this.walletTimestamp = walletTimestamp;
  }

  public User getUser() {

    return user;
  }

  public void setUser(User user) {

    this.user = user;
  }

  public List<WalletTransactionHistory> getTransactionHistory() {

    return transactionHistory;
  }

  public void setTransactionHistory(List<WalletTransactionHistory> transactionHistory) {

    this.transactionHistory = transactionHistory;
  }

  @Override
  public String toString() {

    return "Wallet{"
        + "id="
        + walletId
        + ", availableBalance="
        + availableBalance
        + ", walletTimestamp="
        + walletTimestamp
        + '}';
  }
}
