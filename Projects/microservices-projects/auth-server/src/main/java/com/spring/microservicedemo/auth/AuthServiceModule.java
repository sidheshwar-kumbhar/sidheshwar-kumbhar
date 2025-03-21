package com.spring.microservicedemo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServiceModule {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceModule.class, args);
	}

}
