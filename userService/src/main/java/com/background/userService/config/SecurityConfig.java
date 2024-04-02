package com.background.userService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 定义PasswordEncoder Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 定义SecurityFilterChain Bean来配置安全策略
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 禁用CSRF
                .authorizeRequests(authz -> authz
                        .requestMatchers("/user/**").permitAll() // 允许/auth/**路径下的所有请求
                        .anyRequest().authenticated()) // 其他所有请求需要认证
                // 替代httpBasic和formLogin的配置
                .httpBasic(httpBasic -> httpBasic.disable()) // 如果需要启用HTTP Basic认证，可以自定义配置
                .formLogin(formLogin -> formLogin.disable()); // 如果需要启用表单登录，可以自定义配置

        return http.build();
    }

    // 可选：自定义UserDetailsService
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     return ...
    // }
}