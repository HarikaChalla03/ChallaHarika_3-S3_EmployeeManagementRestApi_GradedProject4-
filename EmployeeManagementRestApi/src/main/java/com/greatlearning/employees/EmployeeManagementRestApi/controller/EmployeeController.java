package com.greatlearning.employees.EmployeeManagementRestApi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.employees.EmployeeManagementRestApi.entity.Employee;
import com.greatlearning.employees.EmployeeManagementRestApi.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listStudents(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("ListofEmployees", theEmployees);
		return "list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("Employee", theEmployee);
		return "employee-form";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("Employee", theEmployee);
		return "employee-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@RequestParam("emplId") int empId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("country") String country) {
		System.out.println(empId);
		Employee theEmployees;
		if (empId != 0) {
			theEmployees = employeeService.findById(empId);
			theEmployees.setFirstName(firstName);
			theEmployees.setLastName(lastName);
			theEmployees.setEmail(email);
		} else
			theEmployees = new Employee();
		employeeService.save(theEmployees);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employId") int theId) {
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}

	@GetMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;

	}
}
