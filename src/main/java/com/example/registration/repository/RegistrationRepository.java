package com.example.registration.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Employee, Integer> {

	public Employee findByEmailId(String emailId);

	public Employee findByEmailIdAndPasswordAndRole(String emailId, String password, String role);
}
