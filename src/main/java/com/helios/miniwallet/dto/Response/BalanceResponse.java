package com.helios.miniwallet.dto.Response;

import javax.validation.constraints.NotNull;

public class BalanceResponse implements WalletResponse {

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
