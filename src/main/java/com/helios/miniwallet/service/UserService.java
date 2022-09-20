package com.helios.miniwallet.service;

import com.helios.miniwallet.exception.user.MiniWalletUserAlreadyExistsException;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.model.user.User;

public interface UserService {

  User createUser(String username, String password) throws MiniWalletUserAlreadyExistsException;

  User findUser(String username) throws MiniWalletUserNotFoundException;
}
