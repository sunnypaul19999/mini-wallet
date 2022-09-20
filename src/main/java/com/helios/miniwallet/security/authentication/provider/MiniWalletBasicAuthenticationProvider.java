package com.helios.miniwallet.security.authentication.provider;

import com.helios.miniwallet.exception.user.MiniWalletUserNotFoundException;
import com.helios.miniwallet.model.user.User;
import com.helios.miniwallet.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

public class MiniWalletBasicAuthenticationProvider
    implements AuthenticationProvider, ApplicationContextAware {

  private UserService userService;

  private PasswordEncoder passwordEncoder;

  private ApplicationContext applicationContext;

  public MiniWalletBasicAuthenticationProvider() {}

  @PostConstruct
  public void init() {

    // initializing bean UserService, PasswordEncoder
    passwordEncoder = applicationContext.getBean(PasswordEncoder.class);
    userService = applicationContext.getBean(UserService.class);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    this.applicationContext = applicationContext;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    try {
      User user = userService.findUser((String) authentication.getPrincipal());

      if (passwordEncoder.matches(
          passwordEncoder.encode((String) authentication.getCredentials()), user.getPassword())) {

        return UsernamePasswordAuthenticationToken.authenticated(
            user.getUsername(),
            user.getPassword(),
            List.of(
                new GrantedAuthority() {

                  @Override
                  public String getAuthority() {

                    return "USER";
                  }
                }));
      } else {

        throw new BadCredentialsException("User not found");
      }

    } catch (MiniWalletUserNotFoundException e) {

      throw new UsernameNotFoundException("User not found");
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {

    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
