package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletSuccessOnDebitResponse implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  private final String message;

  public MiniWalletSuccessOnDebitResponse(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
