package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletSuccessNewUserCreateResponse implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String message;

  public MiniWalletSuccessNewUserCreateResponse(String username) {

    this.message = String.format("Account created successfully %d", username);
  }

  public String getMessage() {

    return message;
  }
}
