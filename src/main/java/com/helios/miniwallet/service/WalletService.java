package com.helios.miniwallet.service;

import com.helios.miniwallet.dto.request.MiniWalletCreditRequest;
import com.helios.miniwallet.dto.request.MiniWalletDebitRequest;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.wallet.Wallet;

public interface WalletService {

  Wallet createNewWallet(User user);

  int availableBalance(String username);

  void debitAmt(MiniWalletDebitRequest debitRequest);

  void creditAmt(MiniWalletCreditRequest creditRequest);
}
