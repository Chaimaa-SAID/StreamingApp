package com.example.StremingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.StremingApp.repository")
@EntityScan(basePackages = "com.example.StremingApp.model")
public class StremingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StremingAppApplication.class, args);
	}
}