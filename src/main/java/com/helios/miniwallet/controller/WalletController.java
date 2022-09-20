package com.helios.miniwallet.controller;

import com.helios.miniwallet.dto.request.MiniWalletRequestCredit;
import com.helios.miniwallet.dto.request.MiniWalletRequestDebit;
import com.helios.miniwallet.dto.response.*;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.exception.wallet.MiniWalletInvalidTransactionAmountException;
import com.helios.miniwallet.exception.wallet.MiniWalletMinimumBalanceException;
import com.helios.miniwallet.model.wallet.Wallet;
import com.helios.miniwallet.model.walletransaction.WalletTransactionHistory;
import com.helios.miniwallet.service.WalletService;
import com.helios.miniwallet.service.WalletTransactionHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/user/acct")
public class WalletController {

  private final WalletService walletService;

  private final WalletTransactionHistoryService walletTransactionHistoryService;

  public WalletController(
      WalletService walletService,
      WalletTransactionHistoryService walletTransactionHistoryService) {

    this.walletService = walletService;
    this.walletTransactionHistoryService = walletTransactionHistoryService;
  }

  @GetMapping(path = "/balance")
  public MiniWalletResponse fetchBalance(HttpServletResponse httpServletResponse)
      throws MiniWalletUserNotFoundException {

    final String userDetails =
        (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    long availableBalance = walletService.availableBalance(userDetails);

    return new MiniWalletResponseSuccessBalance(availableBalance, "Balance fetched successfully");
  }

  @PostMapping(path = "/credit")
  public MiniWalletResponse creditWallet(
      HttpServletResponse httpServletResponse,
      @Valid @RequestBody MiniWalletRequestCredit creditRequest,
      BindingResult bindingResult)
      throws MiniWalletUserNotFoundException {

    creditRequest.setUsername(getUsername());

    Wallet wallet = walletService.creditAmt(creditRequest);

    return new MiniWalletResponseSuccessOnCredit(
        creditRequest.getAmt(), wallet.getWalletTimestamp().getTime(), "Wallet Credited");
  }

  @PostMapping(path = "/debit")
  public MiniWalletResponse debitWallet(
      HttpServletResponse httpServletResponse,
      @Valid @RequestBody MiniWalletRequestDebit debitRequest,
      BindingResult bindingResult)
      throws MiniWalletUserNotFoundException, MiniWalletInvalidTransactionAmountException {

    debitRequest.setUsername(getUsername());

    try {

      Wallet wallet = walletService.debitAmt(debitRequest);

      return new MiniWalletResponseSuccessOnDebit(
          debitRequest.getAmt(), wallet.getWalletTimestamp().getTime(), "Wallet Debited");

    } catch (MiniWalletMinimumBalanceException e) {

      httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());

      return new MiniWalletResponseFailureOnDebit(
          debitRequest.getAmt(), new Date().getTime(), "Wallet does not minimum balance");
    }
  }

  @GetMapping(path = "/transaction/all")
  public List<MiniWalletResponse> fetchWalletTransactionHistory(
      HttpServletResponse httpServletResponse,
      @Valid @RequestBody MiniWalletRequestCredit creditRequest,
      BindingResult bindingResult)
      throws MiniWalletUserNotFoundException {

    List<WalletTransactionHistory> transactionHistoryList =
        walletTransactionHistoryService.getTransactionHistory(getUsername());
  
    return transactionHistoryList.stream()
        .map(
            (transactionHistory) ->
                (MiniWalletResponse)
                    (new MiniWalletResponseSuccessTransactionHistory(
                        transactionHistory.getId(),
                        transactionHistory.getWalletTransactionAmount(),
                        transactionHistory.getWalletTransactionTimestamp().getTime(),
                        transactionHistory.getWalletTransactionBalance())))
        .toList();
  }

  private String getUsername() {

    return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

  @GetMapping(path = "/debug")
  public String debugMiniWallet() {

    return "debug";
  }
}
