package com.helios.miniwallet.Repository;

import com.helios.miniwallet.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {}
