package com.helios.miniwallet.model.user;

import com.helios.miniwallet.model.wallet.Wallet;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "mini_wallet_user")
public class User {

  @Id
  @Column(name = "user_id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Version
  @Column(name = "mini_wallet_user_timestamp", nullable = false)
  private Timestamp miniWalletUserTimestamp;

  @Column(name = "jwt_token")
  private String jwtToken;

  @OneToOne(mappedBy = "user")
  private Wallet wallet;

  public User() {}

  public User(String username, String password) {

    this.username = username;
    this.password = password;
  }

  public long getUserId() {

    return userId;
  }

  public void setUserId(long userId) {

    this.userId = userId;
  }

  public String getUsername() {

    return username;
  }

  public void setUsername(String username) {

    this.username = username;
  }

  public String getJwtToken() {

    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {

    this.jwtToken = jwtToken;
  }

  public String getPassword() {

    return password;
  }

  public void setPassword(String password) {

    this.password = password;
  }

  public Timestamp getMiniWalletUserTimestamp() {

    return miniWalletUserTimestamp;
  }

  public void setMiniWalletUserTimestamp(Timestamp miniWalletUserTimestamp) {

    this.miniWalletUserTimestamp = miniWalletUserTimestamp;
  }

  public Wallet getWallet() {

    return wallet;
  }

  public void setWallet(Wallet wallet) {

    this.wallet = wallet;
  }

  @Override
  public String toString() {

    return "User{"
        + "userId="
        + userId
        + ", username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
}
