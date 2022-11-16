package com.greatlearning.employees.EmployeeManagementRestApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.employees.EmployeeManagementRestApi.config.MyUserDetails;
import com.greatlearning.employees.EmployeeManagementRestApi.entity.User;
import com.greatlearning.employees.EmployeeManagementRestApi.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUsername(username);
		return new MyUserDetails(user);

	}

}
