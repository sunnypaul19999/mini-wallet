package com.helios.miniwallet.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniWalletRequestNewUser implements MiniWalletRequest {

  @NotNull
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String username;

  @NotNull
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  public MiniWalletRequestNewUser(String username, String password) {

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
