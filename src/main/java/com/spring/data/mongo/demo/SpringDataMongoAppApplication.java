package com.spring.data.mongo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.spring.data.mongo.*")
@EntityScan(basePackages="com.spring.data.mongo.*")
@EnableMongoRepositories(basePackages="com.spring.data.mongo.*")
public class SpringDataMongoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoAppApplication.class, args);
	}

}
