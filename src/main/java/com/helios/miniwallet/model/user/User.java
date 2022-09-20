package com.helios.miniwallet.model.user;

import com.helios.miniwallet.model.wallet.Wallet;

import javax.persistence.*;

@Entity(name = "mini_wallet_user")
public class User {

  @Column(name = "username", nullable = false, unique = true)
  private final String username;

  @Column(name = "jwt_token")
  private String jwtToken;

  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
  private Wallet wallet;

  @Id
  @Column(name = "user_id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "password", nullable = false)
  private String password;

  public User(String username, String password) {

    this.username = username;
    this.password = password;
  }

  public User(int id, String username, String password, String jwtToken) {

    this.id = id;
    this.username = username;
    this.password = password;
    this.jwtToken = jwtToken;
  }

  public int getId() {

    return id;
  }

  public String getUsername() {

    return username;
  }

  public String getPassword() {

    return password;
  }

  public void setPassword(String password) {

    this.password = password;
  }

  public Wallet getWallet() {

    return wallet;
  }

  public void setWallet(Wallet wallet) {

    this.wallet = wallet;
  }

  public String getJwtToken() {

    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {

    this.jwtToken = jwtToken;
  }
}
