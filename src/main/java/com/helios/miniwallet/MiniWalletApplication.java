package com.helios.miniwallet;

import com.helios.miniwallet.security.authentication.provider.MiniWalletBasicAuthenticationProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class MiniWalletApplication {

  public static void main(String[] args) {
    SpringApplication.run(MiniWalletApplication.class, args);
  }

  public void configureCors(HttpSecurity http) throws Exception {

    http.cors(
        corsConfigurer -> {
          CorsConfigurationSource configurationSource =
              httpRequest -> {
                CorsConfiguration corsConfiguration = new CorsConfiguration();

                corsConfiguration.setAllowedOrigins(
                    List.of("http://localhost:3000", "http://localhost:3001"));

                // client will be sending in cookies and the authorization header
                corsConfiguration.setAllowCredentials(true);

                // when client is sending credentials sending from server '*' will fail cors
                // we need add all required headers in Access-Control-Allow-Headers (allowedHeaders)
                // So, if we wanted to accept all headers we need type it individually, cumbersome
                // Spring makes it easy by replacing '*' with incoming headers instead of '*' so
                // need to worry, and we can accept all incoming headers even if client is sending
                // credentials
                corsConfiguration.addAllowedHeader("*");

                corsConfiguration.setAllowedMethods(
                    List.of(
                        HttpMethod.GET.toString(),
                        HttpMethod.POST.toString(),
                        HttpMethod.DELETE.toString(),
                        HttpMethod.PUT.toString()));

                return corsConfiguration;
              };

          corsConfigurer.configurationSource(configurationSource);
        });
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // csrf disabled
    http.csrf().disable();

    http.cors().disable();

    http.authenticationProvider(miniWalletBasicAuthenticationProvider());

    http.authorizeRequests()
        .mvcMatchers("**/user/create", "**/user/debug")
        .permitAll()
        .mvcMatchers("**/user/acct/balance")
        .authenticated();

    http.httpBasic();

    return http.build();
  }

  @Bean
  public AuthenticationProvider miniWalletBasicAuthenticationProvider() {

    return new MiniWalletBasicAuthenticationProvider();
  }

  @Bean
  protected PasswordEncoder passwordEncoder() {

    return NoOpPasswordEncoder.getInstance();
  }
}
