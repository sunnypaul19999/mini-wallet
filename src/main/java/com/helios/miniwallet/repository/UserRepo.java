package com.helios.miniwallet.repository;

import com.helios.miniwallet.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

  Optional<User> findByUsername(String username);

  boolean existsByUsername(String username);
}
