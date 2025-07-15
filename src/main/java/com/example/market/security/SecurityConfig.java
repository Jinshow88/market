package com.example.market.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/swagger/**", "/v3/api-docs/**").permitAll()
                // .requestMatchers("/api/user/sign-up").permitAll() // 회원가입 API는 익명 사용자도 접근
                // 가능하게 설정
                // .requestMatchers( "api/user**", "api/user/**" ).authenticated() // /api/user
                // 하위 경로는 인증 필요
                // .requestMatchers("/api/admin/**").hasRole("ADMIN") // /api/admin/** 경로는 ADMIN
                // 권한 필요
                .anyRequest().permitAll() // 그 외 모든 요청은 허용
                .and()
                .httpBasic(); // 또는 formLogin()

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}