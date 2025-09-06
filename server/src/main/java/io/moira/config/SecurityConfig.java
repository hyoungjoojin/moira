package io.moira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf(csrf -> csrf.disable());

    httpSecurity.cors(cors -> cors.disable());

    httpSecurity
        .formLogin(formLogin -> formLogin.disable())
        .logout(logout -> logout.disable())
        .rememberMe(rememberMe -> rememberMe.disable());

    httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().permitAll());

    return httpSecurity.build();
  }
}
