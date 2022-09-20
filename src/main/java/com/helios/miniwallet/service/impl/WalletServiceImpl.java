package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.dto.request.CreditRequest;
import com.helios.miniwallet.dto.request.DebitRequest;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.wallet.Wallet;
import com.helios.miniwallet.repository.WalletRepo;
import com.helios.miniwallet.service.UserService;
import com.helios.miniwallet.service.WalletService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WalletServiceImpl implements WalletService {

  private final UserService userService;

  private final WalletRepo walletRepo;

  WalletServiceImpl(UserService userService, WalletRepo walletRepo) {

    this.userService = userService;
    this.walletRepo = walletRepo;
  }

  @Override
  @Transactional(value = Transactional.TxType.MANDATORY)
  public Wallet createNewWallet(User user) {

    Wallet wallet = new Wallet(user, 0);

    wallet = walletRepo.save(wallet);

    return wallet;
  }

  @Override
  public int availableBalance(String username) {

    return 0;
  }

  @Override
  public void debitAmt(DebitRequest debitRequest) {}

  @Override
  public void creditAmt(CreditRequest creditRequest) {}
}
