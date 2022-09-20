package com.helios.miniwallet.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewMiniWalletUser implements MiniWalletRequest {

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private final String username;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private final String password;

  public NewMiniWalletUser(String username, String password) {

    this.username = username;
    this.password = password;
  }

  public String getUsername() {

    return username;
  }

  public String getPassword() {

    return password;
  }
}
