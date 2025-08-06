package com.example.market.common.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {
    private String jwtSecret;
    private long jwtExpirationMs;

    private Jwt jwt = new Jwt(); // ✅ 기본 생성자 기반 객체 생성

    @Getter
    @Setter
    public static class Jwt {
        private String secret;
        private String headerSchemaName;
        private String tokenType;
        private long accessTokenExpiry;
        private long refreshTokenExpiry;
        private String refreshTokenCookieName;
        private int refreshTokenCookieMaxAge;

        public Jwt() {
        } // ✅ 반드시 필요

        public void setRefreshTokenExpiry(long refreshTokenExpiry) {
            this.refreshTokenExpiry = refreshTokenExpiry;
            this.refreshTokenCookieMaxAge = (int) (refreshTokenExpiry * 0.001);
        }
    }
}
