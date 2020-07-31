package com.azhar.scannerrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

public class ScannerRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerRestApiApplication.class, args);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll();
	}

}
