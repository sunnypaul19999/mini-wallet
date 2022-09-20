package com.helios.miniwallet.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helios.miniwallet.model.walletransaction.WalletTransactionAction;

public class MiniWalletResponseSuccessTransactionHistory implements MiniWalletResponse {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionId;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionAmount;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionTimestamp;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final long transactionBalance;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private final WalletTransactionAction transactionAction;

  public MiniWalletResponseSuccessTransactionHistory(
      long transactionId,
      long transactionAmount,
      long transactionTimestamp,
      long transactionBalance,
      WalletTransactionAction transactionAction) {

    this.transactionId = transactionId;
    this.transactionAmount = transactionAmount;
    this.transactionTimestamp = transactionTimestamp;
    this.transactionBalance = transactionBalance;
    this.transactionAction = transactionAction;
  }

  public long getTransactionId() {

    return transactionId;
  }

  public long getTransactionAmount() {

    return transactionAmount;
  }

  public long getTransactionTimestamp() {

    return transactionTimestamp;
  }

  public long getTransactionBalance() {

    return transactionBalance;
  }

  public WalletTransactionAction getTransactionAction() {

    return transactionAction;
  }
}
