package com.helios.miniwallet.exception.user;

public class MiniWalletUserNotFoundException extends MiniWalletUserException {

  public MiniWalletUserNotFoundException(String username) {

    super(String.format("User not found: %d", username));
  }
}
