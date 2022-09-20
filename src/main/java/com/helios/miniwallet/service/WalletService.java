package com.helios.miniwallet.service;

import com.helios.miniwallet.dto.request.MiniWalletRequestCredit;
import com.helios.miniwallet.dto.request.MiniWalletRequestDebit;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.wallet.Wallet;

public interface WalletService {

  Wallet createNewWallet(User user);

  long availableBalance(String username) throws MiniWalletUserNotFoundException;

  void debitAmt(MiniWalletRequestDebit debitRequest) throws MiniWalletUserNotFoundException;

  void creditAmt(MiniWalletRequestCredit creditRequest) throws MiniWalletUserNotFoundException;
}
