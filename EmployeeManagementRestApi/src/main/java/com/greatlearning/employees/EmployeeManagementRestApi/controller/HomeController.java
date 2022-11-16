package com.greatlearning.employees.EmployeeManagementRestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String showHomePage() {

		System.out.println("Working");

		return "home";

	}
}
