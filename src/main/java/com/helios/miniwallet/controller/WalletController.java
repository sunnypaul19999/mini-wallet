package com.helios.miniwallet.controller;

import com.helios.miniwallet.service.WalletService;
import com.helios.miniwallet.dto.response.BalanceResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    final UserDetails userDetails =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return new BalanceResponse(
        walletService.availableBalance(userDetails.getUsername()), "Balance fetched successfully");
  }
}
