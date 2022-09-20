package com.helios.miniwallet.service;

import com.helios.miniwallet.dto.request.CreditRequest;
import com.helios.miniwallet.dto.request.DebitRequest;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.wallet.Wallet;

public interface WalletService {

  Wallet createNewWallet(User user);

  int availableBalance(String username);

  void debitAmt(DebitRequest debitRequest);

  void creditAmt(CreditRequest creditRequest);
}
