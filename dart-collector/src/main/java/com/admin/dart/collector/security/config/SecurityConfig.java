package com.admin.dart.collector.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SPRING 보안설정
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .csrf()
                .disable();

        // http
        // .antMatcher("/**")
        // .authorizeRequests()
        // .anyRequest()
        // .hasRole("USER")
        // .and()
        // .formLogin()
        // .loginProcessingUrl("/login")
        // .defaultSuccessUrl("/home.html", true)
        // .permitAll()
        // .and()
        // .csrf()
        // .disable();

        // http
        // .authorizeRequests()
        // .antMatchers("/", "/home")
        // .permitAll()
        // .anyRequest()
        // .authenticated()
        // .and()
        // .formLogin()
        // .loginPage("/login")
        // .permitAll()
        // .and()
        // .logout()
        // .permitAll();

        return http.build();
    }
}
