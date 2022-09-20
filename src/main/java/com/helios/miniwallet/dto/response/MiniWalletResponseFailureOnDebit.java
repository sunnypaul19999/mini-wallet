package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletResponseFailureOnDebit implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long amount;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long timestamp;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String message;

  public MiniWalletResponseFailureOnDebit(long amount, long timestamp, String message) {

    this.amount = amount;
    this.timestamp = timestamp;
    this.message = message;
  }

  public long getAmount() {

    return amount;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public String getMessage() {

    return message;
  }
}
