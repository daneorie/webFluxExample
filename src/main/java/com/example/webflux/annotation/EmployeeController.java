package com.example.webflux.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webflux.Employee;
import com.example.webflux.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/{id}")
	private Mono<Employee> getEmployeeById(@PathVariable("id") String id) {
		return employeeRepository.findEmployeeById(id);
	}

	@GetMapping
	private Flux<Employee> getAllEmployee() {
		return employeeRepository.findAllEmployees();
	}

	@PostMapping("/update")
	private Mono<Employee> updateEmployee(@RequestBody Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}
	
}
