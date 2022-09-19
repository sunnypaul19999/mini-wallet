package com.helios.miniwallet.Service;

import com.helios.miniwallet.Model.User.User;

public interface UserService {

  public void createUser(String username, String password);

  public User findUser(String username);
}
