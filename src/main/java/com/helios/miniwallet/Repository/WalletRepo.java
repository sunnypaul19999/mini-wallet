package com.helios.miniwallet.Repository;

import com.helios.miniwallet.Model.Wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet, Integer> {}
