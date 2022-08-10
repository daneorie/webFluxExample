package com.example.webflux.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.webflux.EmployeeRepository;

@SpringBootApplication(exclude = MongoReactiveAutoConfiguration.class)
public class EmployeeSpringApplication {

	@Bean
	public EmployeeRepository employeeRepository() {
		return new EmployeeRepository();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringApplication.class, args);

		EmployeeWebClient employeeWebClient = new EmployeeWebClient();
		employeeWebClient.consunme();
	}

}
