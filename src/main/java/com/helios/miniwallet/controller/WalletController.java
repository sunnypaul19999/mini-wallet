package com.helios.miniwallet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController(value = "/user/acct")
public class WalletController {

  @GetMapping(name = "/balance")
  String fetchBalance(HttpServletResponse httpServletResponse) {

    return "balance";
  }

  @PostMapping(name = "/credit")
  String creditAcct(HttpServletResponse httpServletResponse) {

    return "balance";
  }

  @PutMapping(name = "/debit")
  String debitAcct(HttpServletResponse httpServletResponse) {

    return "balance";
  }
}
