package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.exception.user.MiniWalletUserAlreadyExistsException;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.repository.UserRepo;
import com.helios.miniwallet.service.UserService;
import com.helios.miniwallet.service.WalletService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  private final WalletService walletService;

  public UserServiceImpl(UserRepo userRepo, @Lazy WalletService walletService) {

    this.userRepo = userRepo;
    this.walletService = walletService;
  }

  @Override
  @Transactional(
      isolation = Isolation.SERIALIZABLE,
      propagation = Propagation.REQUIRES_NEW,
      rollbackFor = {MiniWalletUserAlreadyExistsException.class})
  public User createUser(String username, String password)
      throws MiniWalletUserAlreadyExistsException {

    if (userRepo.existsByUsername(username)) {

      throw new MiniWalletUserAlreadyExistsException(username);
    }

    User user = new User(username, password);

    user = userRepo.save(user);

    //    walletService.createNewWallet(user);

    return user;
  }

  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
  public User findUser(String username) throws MiniWalletUserNotFoundException {

    Optional<User> user = userRepo.findByUsername(username);

    if (user.isEmpty()) {

      throw new MiniWalletUserNotFoundException(username);
    }

    return user.get();
  }
}
