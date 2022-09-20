package com.helios.miniwallet.exception.wallet;

import com.helios.miniwallet.exception.MiniWalletException;

public class MiniWalletInvalidTransactionAmountException extends MiniWalletException {

  private final long transactionTimestamp;

  private final long transactionAmount;

  public MiniWalletInvalidTransactionAmountException(
      long transactionAmount, long transactionTimestamp, String message) {

    super(message);
    this.transactionTimestamp = transactionTimestamp;
    this.transactionAmount = transactionAmount;
  }

  public long getTransactionAmount() {

    return transactionAmount;
  }

  public long getTransactionTimestamp() {

    return transactionTimestamp;
  }
}
