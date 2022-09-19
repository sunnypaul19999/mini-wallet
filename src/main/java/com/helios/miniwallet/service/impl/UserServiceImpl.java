package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.repository.UserRepo;
import com.helios.miniwallet.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  public UserServiceImpl(UserRepo userRepo) {

    this.userRepo = userRepo;
  }

  @Override
  public void createUser(String username, String password) {}

  @Override
  public User findUser(String username) {

    return null;
  }
}
