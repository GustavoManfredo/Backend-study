package com.api.carshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarshopApplication.class, args);
	}

}
