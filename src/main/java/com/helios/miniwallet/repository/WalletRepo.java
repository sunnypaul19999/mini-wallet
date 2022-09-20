package com.helios.miniwallet.repository;

import com.helios.miniwallet.model.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepo extends JpaRepository<Wallet, Integer> {

  Optional<Wallet> findByUserUserId(long userId);
}
