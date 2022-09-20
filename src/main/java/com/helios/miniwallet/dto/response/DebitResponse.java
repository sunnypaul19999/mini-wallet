package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DebitResponse implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  private final String message;

  public DebitResponse(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
