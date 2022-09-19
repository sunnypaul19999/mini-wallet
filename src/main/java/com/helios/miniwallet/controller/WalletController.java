package com.helios.miniwallet.controller;

import com.helios.miniwallet.Service.WalletService;
import com.helios.miniwallet.dto.Response.BalanceResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/user/acct")
public class WalletController {

  private final WalletService walletService;

  public WalletController(WalletService walletService) {

    this.walletService = walletService;
  }

  @GetMapping("/balance")
  public BalanceResponse fetchBalance(HttpServletResponse httpServletResponse) {

    final var authentication = SecurityContextHolder.getContext().getAuthentication();

    final String username = "user"; // ((Principal) authentication.getPrincipal()).getName();

    return new BalanceResponse(
        walletService.availableBalance(username), "Balance fetched successfully");
  }
}
