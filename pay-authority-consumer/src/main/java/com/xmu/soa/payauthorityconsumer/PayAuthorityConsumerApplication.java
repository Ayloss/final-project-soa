package com.xmu.soa.payauthorityconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PayAuthorityConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayAuthorityConsumerApplication.class, args);
	}
}
