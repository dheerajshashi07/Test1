package com.example.registration.controller;

import com.example.model.Employee;
import com.example.model.PatientDetails;
import com.example.registration.repository.PatientDetailsRepository;
import com.example.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class RegistrationController {

	@Autowired
	private RegistrationService service;
	@Autowired
	@Qualifier("patientDetailsRepoClass")
	private PatientDetailsRepository patientDetailsRepository;

	@PostMapping("/registerUser")

	public Employee registerUser(@RequestBody Employee user) throws Exception {
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			Employee userObj = service.fetchUserBYEmailId(tempEmailId);
			if (userObj != null) {
				throw new Exception("user with " + tempEmailId + "are already existsed");
			}
		}
		Employee userobj = null;
		userobj = service.saveUser(user);

		return userobj;
	}

	@PostMapping("/login/employee")

	public Employee loginUser(@RequestBody Employee user) throws Exception {
		String tempEmailId = user.getEmailId();
		String temppassword = user.getPassword();
		String role = user.getRole();
		Employee userobj = null;
		if (tempEmailId != null && temppassword != null && role != null) {

			userobj = service.fetchByEmailIdAndPasswordAndRole(tempEmailId, temppassword, role);
			if (userobj == null) {
				throw new Exception("Bad Credentials");
			}

		}
		return userobj;
	}

	@PostMapping("/login/patient")
	public PatientDetails loginUser(@RequestBody PatientDetails user) throws Exception {
		String tempEmailId = user.getEmailId();
		String temppassword = user.getPassword();
		String role = user.getRole();
		PatientDetails userobj = null;
		userobj = patientDetailsRepository.findByEmailIdAndPasswordAndRole(tempEmailId, temppassword, role);
		if (userobj == null) {
			throw new Exception("Bad Credentials");
		} else {
			return userobj;
		}

	}

	@PostMapping("getAllEmployeesList")
	public List<Employee> findAllEmployeesList() {
		return service.findAll();
	}

}


	

