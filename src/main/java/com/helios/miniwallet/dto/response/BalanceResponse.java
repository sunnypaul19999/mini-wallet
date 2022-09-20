package com.helios.miniwallet.dto.response;

import javax.validation.constraints.NotNull;

public class BalanceResponse implements MiniWalletResponse {

  @NotNull private final long balance;

  @NotNull private final String message;

  public BalanceResponse(long balance, String message) {

    this.balance = balance;
    this.message = message;
  }

  public long getBalance() {

    return balance;
  }

  public String getMessage() {

    return message;
  }
}
