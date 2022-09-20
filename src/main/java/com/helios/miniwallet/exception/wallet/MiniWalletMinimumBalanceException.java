package com.helios.miniwallet.exception.wallet;

import com.helios.miniwallet.exception.MiniWalletException;

public class MiniWalletMinimumBalanceException extends Exception implements MiniWalletException {

  public MiniWalletMinimumBalanceException(String message) {

    super(message);
  }
}
