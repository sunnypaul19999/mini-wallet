package com.helios.miniwallet.controller;

import com.helios.miniwallet.dto.response.MiniWalletResponse;
import com.helios.miniwallet.dto.response.MiniWalletResponseUserAlreadyExists;
import com.helios.miniwallet.exception.user.MiniWalletUserAlreadyExistsException;
import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalController {

  @ExceptionHandler(value = {MiniWalletUserNotFoundException.class})
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public MiniWalletResponse userNotFoundExceptionHandler(MiniWalletUserNotFoundException e) {

    return new MiniWalletResponseUserAlreadyExists(e.getMessage());
  }

  @ExceptionHandler(value = MiniWalletUserAlreadyExistsException.class)
  @ResponseStatus(code = HttpStatus.CONFLICT)
  public MiniWalletResponse userAlreadyExistsExceptionHandler(
      MiniWalletUserAlreadyExistsException e) {

    return new MiniWalletResponseUserAlreadyExists(e.getMessage());
  }
}
