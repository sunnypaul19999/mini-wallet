package com.helios.miniwallet.controller;

import com.helios.miniwallet.dto.request.MiniWalletRequestNewUser;
import com.helios.miniwallet.dto.response.MiniWalletResponse;
import com.helios.miniwallet.dto.response.MiniWalletResponseSuccessNewUserCreate;
import com.helios.miniwallet.exception.user.MiniWalletUserAlreadyExistsException;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  private final UserService userService;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public UserController(UserService userService) {

    this.userService = userService;
  }

  @PostMapping(path = "/create")
  public MiniWalletResponse createMiniWalletUser(
      HttpServletResponse httpServletResponse,
      @Valid @RequestBody MiniWalletRequestNewUser newUser,
      BindingResult bindingResult)
      throws MiniWalletUserAlreadyExistsException {

    User user = userService.createUser(newUser.getUsername(), newUser.getPassword());

    return new MiniWalletResponseSuccessNewUserCreate(user.getUserId(), user.getUsername());
  }

  @GetMapping(path = "/debug")
  public String debugMiniWallet() {

    return "debug";
  }
}
