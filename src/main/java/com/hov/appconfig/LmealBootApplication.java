package com.hov.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hov"})
@EnableMongoRepositories(basePackages = {"com.hov.repository"})
public class LmealBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(LmealBootApplication.class, args);
	}
}
