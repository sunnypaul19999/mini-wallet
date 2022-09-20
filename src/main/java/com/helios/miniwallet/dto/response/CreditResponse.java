package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditResponse implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  private final String message;

  public CreditResponse(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
