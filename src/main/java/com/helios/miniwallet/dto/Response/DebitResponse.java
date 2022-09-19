package com.helios.miniwallet.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DebitResponse implements WalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  private final String message;

  public DebitResponse(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
