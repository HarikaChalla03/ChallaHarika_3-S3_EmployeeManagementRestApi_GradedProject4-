package com.greatlearning.employees.EmployeeManagementRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employees.EmployeeManagementRestApi.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<User, Integer> {

}
