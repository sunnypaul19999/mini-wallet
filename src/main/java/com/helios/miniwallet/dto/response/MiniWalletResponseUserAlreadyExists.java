package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletResponseUserAlreadyExists implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String message;

  public MiniWalletResponseUserAlreadyExists(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
