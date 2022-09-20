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
  private long id;

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

  public Wallet(User user, long availableBalance) {

    this.user = user;
    this.availableBalance = availableBalance;
  }

  public Wallet(long id, long availableBalance, Timestamp walletTimestamp) {

    this.id = id;
    this.availableBalance = availableBalance;
    this.walletTimestamp = walletTimestamp;
  }

  public long getId() {

    return id;
  }

  public Timestamp getWalletTimestamp() {

    return walletTimestamp;
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
}
