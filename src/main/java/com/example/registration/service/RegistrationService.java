package com.example.registration.service;

import com.example.model.Employee;
import com.example.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;

	public Employee saveUser(Employee user) {
		return repo.save(user);
	}

	public List<Employee> findAll() {
		return repo.findAll();
	}

	public Employee fetchUserBYEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}

	public Employee fetchByEmailIdAndPasswordAndRole(String emailId, String password, String role) {
		return repo.findByEmailIdAndPasswordAndRole(emailId, password, role);
	}
}
