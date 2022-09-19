package com.helios.miniwallet.Repository;

import com.helios.miniwallet.Model.Wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepo extends JpaRepository<Wallet, Integer> {

  Optional<Wallet> findByUserId(long userId);
}
