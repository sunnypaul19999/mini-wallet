package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletResponseSuccessOnCredit implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long creditAmount;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long timestamp;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String message;

  public MiniWalletResponseSuccessOnCredit(long creditAmount, long timestamp, String message) {

    this.creditAmount = creditAmount;
    this.timestamp = timestamp;
    this.message = message;
  }

  public long getCreditAmount() {

    return creditAmount;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public String getMessage() {

    return message;
  }
}
