package com.example.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.store")
public class StoreSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreSalesApplication.class, args);
	}

}
