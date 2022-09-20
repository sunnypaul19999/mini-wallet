package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletResponseUserNotFound {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String message;

  public MiniWalletResponseUserNotFound(String message) {

    this.message = message;
  }

  public String getMessage() {

    return message;
  }
}
