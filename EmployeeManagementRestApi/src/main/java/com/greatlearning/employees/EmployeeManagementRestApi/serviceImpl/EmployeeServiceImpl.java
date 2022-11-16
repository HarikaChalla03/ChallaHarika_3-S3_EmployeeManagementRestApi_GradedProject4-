package com.greatlearning.employees.EmployeeManagementRestApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.greatlearning.employees.EmployeeManagementRestApi.entity.Employee;
import com.greatlearning.employees.EmployeeManagementRestApi.repository.EmployeeRepository;
import com.greatlearning.employees.EmployeeManagementRestApi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Transactional
	public Employee findById(int theId) {
		Employee employee = new Employee();
		employee = employeeRepository.findById(theId).get();
		return employee;
	}

	@Transactional
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	@Transactional
	public List<Employee> searchBy(String firstName, String department) {
		List<Employee> employees = employeeRepository.searchBy(firstName, department);
		return employees;

	}

}
