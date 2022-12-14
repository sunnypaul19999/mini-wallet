package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletResponseSuccessOnDebit implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long debitAmount;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long timestamp;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  private final String message;

  public MiniWalletResponseSuccessOnDebit(long debitAmount, long timestamp, String message) {

    this.debitAmount = debitAmount;
    this.timestamp = timestamp;
    this.message = message;
  }

  public long getDebitAmount() {

    return debitAmount;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public String getMessage() {

    return message;
  }
}
