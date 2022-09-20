package com.helios.miniwallet.controller;

import com.helios.miniwallet.dto.request.NewMiniWalletUser;
import com.helios.miniwallet.dto.response.MiniWalletResponse;
import com.helios.miniwallet.dto.response.MiniWalletSuccessNewUserCreateResponse;
import com.helios.miniwallet.dto.response.MiniWalletUserAlreadyExistsResponse;
import com.helios.miniwallet.exception.user.MiniWalletUserAlreadyExistsException;
import com.helios.miniwallet.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(name = "/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {

    this.userService = userService;
  }

  @PostMapping
  public MiniWalletResponse createMiniWalletUser(
      HttpServletResponse httpServletResponse,
      @Valid NewMiniWalletUser newUser,
      BindingResult bindingResult) {

    try {

      userService.createUser(newUser.getUsername(), newUser.getPassword());

      return new MiniWalletSuccessNewUserCreateResponse(newUser.getUsername());

    } catch (MiniWalletUserAlreadyExistsException e) {

      httpServletResponse.setStatus(409);

      return new MiniWalletUserAlreadyExistsResponse(newUser.getUsername());
    }
  }
}
