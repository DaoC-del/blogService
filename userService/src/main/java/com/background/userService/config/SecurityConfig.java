package com.background.userService.config;

import com.background.userService.util.JwtTokenFilter;
import com.background.userService.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

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
                .formLogin(formLogin -> formLogin.disable())
                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
        ; // 如果需要启用表单登录，可以自定义配置
        return http.build();
    }

}
