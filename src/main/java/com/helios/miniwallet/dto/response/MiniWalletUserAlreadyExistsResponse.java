package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MiniWalletUserAlreadyExistsResponse implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String message;

  public MiniWalletUserAlreadyExistsResponse(String username) {

    this.message = String.format("User with username %d already exists", username);
  }

  public String getMessage() {

    return message;
  }
}
