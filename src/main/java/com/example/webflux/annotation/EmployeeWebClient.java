package com.example.webflux.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.webflux.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeWebClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeWebClient.class);

	WebClient client = WebClient.create("https://localhost:8080");

	public void consunme() {

		Mono<Employee> employeeMono = client.get()
			.uri("/employees/{id}", "1")
			.retrieve()
			.bodyToMono(Employee.class);

		employeeMono.subscribe(employee -> LOGGER.info("Employee: {}", employee));

		Flux<Employee> employeeFlux = client.get()
			.uri("/employees")
			.retrieve()
			.bodyToFlux(Employee.class);

		employeeFlux.subscribe(employee -> LOGGER.info("Employee: {}", employee));

	}
	
}
