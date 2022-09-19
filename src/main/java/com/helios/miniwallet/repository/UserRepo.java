package com.helios.miniwallet.repository;

import com.helios.miniwallet.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {}
