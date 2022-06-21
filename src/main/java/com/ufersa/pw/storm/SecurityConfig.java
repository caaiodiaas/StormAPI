package com.ufersa.pw.storm;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ufersa.pw.storm.api.filters.AuthorizationFilter;
import com.ufersa.pw.storm.api.filters.LoginFilter;
import com.ufersa.pw.storm.domain.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
    throws Exception {
    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf()
      .disable()
      .cors()
      .and()
      .authorizeRequests()
      .antMatchers("/login")
      .permitAll()
      .antMatchers("/usuarios")
      .permitAll()
      .antMatchers("/usuarios/*")
      .permitAll()
      .antMatchers("/carrinhos")
      .permitAll()
      .antMatchers("/carrinhos/*")
      .permitAll()
      .antMatchers("/produtos")
      .permitAll()
      .antMatchers("/produtos/*")
      .permitAll()
      .antMatchers("/enderecos")
      .permitAll()
      .antMatchers("/enderecos/*")
      .permitAll()
      .antMatchers("/compras")
      .permitAll()
      .antMatchers("/compras/*")
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .addFilterBefore(
        new LoginFilter("/login", authenticationManager()),
        UsernamePasswordAuthenticationFilter.class
      )
      .addFilterBefore(
        new AuthorizationFilter(),
        UsernamePasswordAuthenticationFilter.class
      );
  }

}
