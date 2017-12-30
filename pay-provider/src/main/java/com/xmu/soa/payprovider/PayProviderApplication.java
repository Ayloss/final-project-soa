package com.xmu.soa.payprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PayProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayProviderApplication.class, args);
	}
}
