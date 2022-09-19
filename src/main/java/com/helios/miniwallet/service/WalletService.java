package com.helios.miniwallet.service;

import com.helios.miniwallet.dto.request.CreditRequest;
import com.helios.miniwallet.dto.request.DebitRequest;

public interface WalletService {

  public int availableBalance(String username);

  public void debitAmt(DebitRequest debitRequest);

  public void creditAmt(CreditRequest creditRequest);
}
