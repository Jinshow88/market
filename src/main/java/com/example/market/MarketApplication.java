package com.example.market;

import com.example.market.common.security.AppProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

}
