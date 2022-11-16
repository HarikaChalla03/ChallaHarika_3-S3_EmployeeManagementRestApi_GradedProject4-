package com.greatlearning.employees.EmployeeManagementRestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employees.EmployeeManagementRestApi.entity.Employee;

@Service
public interface EmployeeService {
	
    public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

	public List<Employee> searchBy(String firstName, String department);
}
