package com.example.market.common.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
@RequiredArgsConstructor
public class AppProperties {
    private String jwtSecret;
    private Long jwtExpirationMs;
    // 필요한 설정 값들 추가
    private Jwt jwt;

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

        @ConstructorBinding
        public Jwt(String secret, String headerSchemaName, String tokenType, long accessTokenExpiry,
                long refreshTokenExpiry, String refreshTokenCookieName) {
            this.secret = secret;
            this.headerSchemaName = headerSchemaName;
            this.tokenType = tokenType;
            this.accessTokenExpiry = accessTokenExpiry;
            this.refreshTokenExpiry = refreshTokenExpiry;
            this.refreshTokenCookieName = refreshTokenCookieName;
            this.refreshTokenCookieMaxAge = (int) (refreshTokenExpiry * 0.001); // ms > s 변환
        }

    }
}
