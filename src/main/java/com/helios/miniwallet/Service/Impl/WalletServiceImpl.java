package com.helios.miniwallet.Service.Impl;

import com.helios.miniwallet.DTO.Request.CreditRequest;
import com.helios.miniwallet.DTO.Request.DebitRequest;
import com.helios.miniwallet.Model.Wallet.Wallet;
import com.helios.miniwallet.Repository.WalletRepo;
import com.helios.miniwallet.Service.WalletService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class WalletServiceImpl implements WalletService {

  private final WalletRepo walletRepo;

  WalletServiceImpl(WalletRepo walletRepo) {

    this.walletRepo = walletRepo;
  }

  @Override
  public Wallet availableBalance(Principal principal) {

    return null;
  }

  @Override
  public void debitAmt(DebitRequest debitRequest) {}

  @Override
  public void creditAmt(CreditRequest creditRequest) {}
}
