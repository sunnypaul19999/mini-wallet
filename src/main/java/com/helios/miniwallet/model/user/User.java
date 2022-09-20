package com.helios.miniwallet.model.user;

import com.helios.miniwallet.model.wallet.Wallet;

import javax.persistence.*;

@Entity(name = "mini_wallet_user")
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "jwt_token")
  private String jwtToken;

  @OneToOne(mappedBy = "user")
  private Wallet wallet;

  @Column(name = "password", nullable = false)
  private String password;

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

  public Wallet getWallet() {

    return wallet;
  }

  public void setWallet(Wallet wallet) {

    this.wallet = wallet;
  }

  public String getPassword() {

    return password;
  }

  public void setPassword(String password) {

    this.password = password;
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
