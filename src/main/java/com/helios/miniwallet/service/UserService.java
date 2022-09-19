package com.helios.miniwallet.service;

import com.helios.miniwallet.model.user.User;

public interface UserService {

  public void createUser(String username, String password);

  public User findUser(String username);
}
