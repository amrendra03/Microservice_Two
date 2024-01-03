package com.microservices.imitsservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImitsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImitsServicesApplication.class, args);
		System.out.println("from Limiter service...");
	}

}
