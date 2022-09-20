package com.helios.miniwallet.exception.user;

public class MiniWalletUserAlreadyExistsException extends Exception
    implements MiniWalletUserException {

  public MiniWalletUserAlreadyExistsException(String username) {

    super(String.format("User already exists: %s", username));
  }
}
