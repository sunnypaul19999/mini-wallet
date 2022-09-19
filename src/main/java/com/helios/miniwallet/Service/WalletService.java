package com.helios.miniwallet.Service;

import com.helios.miniwallet.DTO.Request.CreditRequest;
import com.helios.miniwallet.DTO.Request.DebitRequest;
import com.helios.miniwallet.Model.Wallet.Wallet;

import java.security.Principal;

public interface WalletService {

  public Wallet availableBalance(String username);

  public void debitAmt(DebitRequest debitRequest);

  public void creditAmt(CreditRequest creditRequest);
}
