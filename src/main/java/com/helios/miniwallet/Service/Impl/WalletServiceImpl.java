package com.helios.miniwallet.Service.Impl;

import com.helios.miniwallet.dto.Request.CreditRequest;
import com.helios.miniwallet.dto.Request.DebitRequest;
import com.helios.miniwallet.Repository.WalletRepo;
import com.helios.miniwallet.Service.UserService;
import com.helios.miniwallet.Service.WalletService;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

  private final UserService userService;

  private final WalletRepo walletRepo;

  WalletServiceImpl(UserService userService, WalletRepo walletRepo) {

    this.userService = userService;
    this.walletRepo = walletRepo;
  }

  @Override
  public int availableBalance(String username) {

    return 0;
  }

  @Override
  public void debitAmt(DebitRequest debitRequest) {
  
  
  }

  @Override
  public void creditAmt(CreditRequest creditRequest) {}
}
