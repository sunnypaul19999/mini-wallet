package com.helios.miniwallet.service.impl;

import com.helios.miniwallet.dto.request.CreditRequest;
import com.helios.miniwallet.dto.request.DebitRequest;
import com.helios.miniwallet.repository.WalletRepo;
import com.helios.miniwallet.service.UserService;
import com.helios.miniwallet.service.WalletService;
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
