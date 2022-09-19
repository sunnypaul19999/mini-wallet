package com.helios.miniwallet.model.user;

import com.helios.miniwallet.model.wallet.Wallet;

import javax.persistence.*;

@Entity(name = "mini_wallet_user")
public class User {

  @Id
  @Column(name = "user_id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final int id;

  @Column(name = "username", nullable = false, unique = true)
  private final String username;

  @Column(name = "jwt_token")
  private final String jwtToken;

  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
  private Wallet wallet;

  public User(int id, String username, String jwtToken) {

    this.id = id;
    this.username = username;
    this.jwtToken = jwtToken;
  }

  public int getId() {

    return id;
  }

  public String getUsername() {

    return username;
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
}
