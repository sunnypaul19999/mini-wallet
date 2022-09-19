package com.helios.miniwallet.DTO.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DebitRequest implements WalletRequest {

  @Min(value = 1, message = "debit value should be greater than 0")
  @JsonProperty(access = JsonProperty.Access.READ_ONLY, required = true)
  long amt;

  @JsonIgnore @NotNull private String username;

  public DebitRequest(long amt) {

    this.amt = amt;
  }

  public long getAmt() {

    return amt;
  }

  public String getUsername() {

    return username;
  }

  public void setUsername(String username) {

    this.username = username;
  }
}
