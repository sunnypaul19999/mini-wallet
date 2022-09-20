package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.annotation.Order;

public class MiniWalletResponseSuccessNewUserCreate implements MiniWalletResponse {

  @Order(1)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long userId;

  @Order(2)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String username;

  @Order(3)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final String message;

  public MiniWalletResponseSuccessNewUserCreate(long userId, String username) {

    this.userId = userId;
    this.username = username;
    this.message = "Account created successfully";
  }

  public long getUserId() {

    return userId;
  }

  public String getUsername() {

    return username;
  }

  public String getMessage() {

    return message;
  }
}
