package com.xmu.soa.servicecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCenterApplication.class, args);
	}
}
