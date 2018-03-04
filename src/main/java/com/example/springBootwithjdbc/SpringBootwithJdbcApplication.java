package com.example.springBootwithjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootwithJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootwithJdbcApplication.class, args);
	}
}
