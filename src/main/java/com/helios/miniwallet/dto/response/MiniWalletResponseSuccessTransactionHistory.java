package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletResponseSuccessTransactionHistory implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionId;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionAmount;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionTimestamp;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionBalance;

  public MiniWalletResponseSuccessTransactionHistory(
      long transactionId,
      long transactionAmount,
      long transactionTimestamp,
      long transactionBalance) {

    this.transactionId = transactionId;
    this.transactionAmount = transactionAmount;
    this.transactionTimestamp = transactionTimestamp;
    this.transactionBalance = transactionBalance;
  }

  public long getTransactionId() {

    return transactionId;
  }

  public long getTransactionAmount() {

    return transactionAmount;
  }

  public long getTransactionTimestamp() {

    return transactionTimestamp;
  }

  public long getTransactionBalance() {

    return transactionBalance;
  }
}
