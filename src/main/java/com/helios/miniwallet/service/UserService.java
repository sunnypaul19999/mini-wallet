package com.helios.miniwallet.service;

import com.helios.miniwallet.exception.user.MiniWalletUserAlreadyExistsException;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.model.user.User;

public interface UserService {

  public void createUser(String username, String password) throws MiniWalletUserAlreadyExistsException;

  public User findUser(String username) throws MiniWalletUserNotFoundException;
}
