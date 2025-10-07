package com.example.market.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // 스웨거/문서 공개
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger/**",
                    "/v3/api-docs/**",
                    "/v3/api-docs.yaml",
                    "/swagger-ui.html"
                ).permitAll()

                // 예시) 회원가입만 공개>
                // .requestMatchers("/api/user/sign-up/**").permitAll()

                // 예시) 일반 사용자 인증 필요
                // .requestMatchers("/api/user/**").authenticated()

                // 예시) 관리자만 접근
                // .requestMatchers("/api/admin/**").hasRole("ADMIN")

                // 그 외 전부 허용 (원하시면 authenticated() 로 바꾸세요)
                .anyRequest().permitAll()
            )
            // httpBasic 또는 formLogin 중 하나 선택
            .httpBasic(Customizer.withDefaults());
            // .formLogin(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}