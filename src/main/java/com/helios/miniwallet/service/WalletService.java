package com.helios.miniwallet.service;

import com.helios.miniwallet.dto.request.MiniWalletRequestCredit;
import com.helios.miniwallet.dto.request.MiniWalletRequestDebit;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.exception.wallet.MiniWalletInvalidTransactionAmountException;
import com.helios.miniwallet.exception.wallet.MiniWalletMinimumBalanceException;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.model.wallet.Wallet;

public interface WalletService {

  Wallet createNewWallet(User user);

  Wallet getWallet(String username) throws MiniWalletUserNotFoundException;

  long availableBalance(String username) throws MiniWalletUserNotFoundException;

  Wallet debitAmt(MiniWalletRequestDebit debitRequest)
      throws MiniWalletUserNotFoundException, MiniWalletInvalidTransactionAmountException,
          MiniWalletMinimumBalanceException;

  Wallet creditAmt(MiniWalletRequestCredit creditRequest) throws MiniWalletUserNotFoundException;
}
