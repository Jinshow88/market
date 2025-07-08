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
    private Long jwtExpirationMs;
    // 필요한 설정 값들 추가
}
