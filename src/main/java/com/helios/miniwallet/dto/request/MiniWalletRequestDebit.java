package com.helios.miniwallet.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniWalletRequestDebit implements MiniWalletRequest {

  @Min(value = 1, message = "debit value should be greater than 0")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, required = true)
  private long amt;

  @JsonIgnore @NotNull private String username;

  public long getAmt() {

    return amt;
  }

  public void setAmt(long amt) {

    this.amt = amt;
  }

  public String getUsername() {

    return username;
  }

  public void setUsername(String username) {

    this.username = username;
  }
}
