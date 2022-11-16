package com.greatlearning.employees.EmployeeManagementRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({ "main.controllers", "main.repositories" })
@EnableJpaRepositories("main.repositories")
@SpringBootApplication(scanBasePackages = { "com.greatlearning.employees.EmployeeManagementRestApi",
		"com.greatlearning.employees.EmployeeManagementRestApi.controller",
		"com.greatlearning.employees.EmployeeManagementRestApi.service",
		"com.greatlearning.employees.EmployeeManagementRestApi.Entity",
		"com.greatlearning.employees.EmployeeManagementRestApi.config",
		"com.greatlearning.employees.EmployeeManagementRestApi.repository",
		"com.greatlearning.employees.EmployeeManagementRestApi.serviceImpl"})
public class EmployeeManagementRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementRestApiApplication.class, args);
	}

}
