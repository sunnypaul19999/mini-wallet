package com.helios.miniwallet.Service.Impl;

import com.helios.miniwallet.Model.User.User;
import com.helios.miniwallet.Repository.UserRepo;
import com.helios.miniwallet.Service.UserService;
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
