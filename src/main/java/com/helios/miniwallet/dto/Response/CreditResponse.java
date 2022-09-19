package com.helios.miniwallet.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditResponse implements WalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  private final String message;

  public CreditResponse(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
