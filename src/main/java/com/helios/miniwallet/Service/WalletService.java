package com.helios.miniwallet.Service;

import com.helios.miniwallet.dto.Request.CreditRequest;
import com.helios.miniwallet.dto.Request.DebitRequest;

public interface WalletService {

  public int availableBalance(String username);

  public void debitAmt(DebitRequest debitRequest);

  public void creditAmt(CreditRequest creditRequest);
}
