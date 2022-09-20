package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletResponseSuccessOnDebit implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  private final String message;

  public MiniWalletResponseSuccessOnDebit(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
