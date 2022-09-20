package com.helios.miniwallet.controller;

import com.helios.miniwallet.dto.response.MiniWalletResponse;
import com.helios.miniwallet.dto.response.MiniWalletSuccessBalanceResponse;
import com.helios.miniwallet.service.WalletService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/user/acct")
public class WalletController {

  private final WalletService walletService;

  public WalletController(WalletService walletService) {

    this.walletService = walletService;
  }

  @GetMapping(path = "/balance")
  public MiniWalletResponse fetchBalance(HttpServletResponse httpServletResponse) {

    final UserDetails userDetails =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return new MiniWalletSuccessBalanceResponse(
        walletService.availableBalance(userDetails.getUsername()), "Balance fetched successfully");
  }

  @GetMapping(path = "/debug")
  public String debugMiniWallet() {

    return "debug";
  }
}
