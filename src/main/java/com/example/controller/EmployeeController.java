package com.example.controller;

import com.example.exception.ResourceNotAvailableException;
import com.example.model.BookingDetails;
import com.example.model.Employee;
import com.example.model.PatientDetails;
import com.example.registration.repository.BookingDetailsRepository;
import com.example.registration.repository.PatientDetailsRepository;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	@Qualifier("patientDetailsRepoClass")
	private PatientDetailsRepository patientDetailsRepository;
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;

	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	//creating employee
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);

	}

	//creating patient
	@PostMapping("/createPatient")
	public int createPatient(@RequestBody PatientDetails patientDetails) {
		return patientDetailsRepository.save(patientDetails);

	}

	@GetMapping("/getAllPatients")
	public List<PatientDetails> patientDetailsList() {
		return patientDetailsRepository.findAll();
	}

	@GetMapping("/getPatient/{doctorName}")
	public List<PatientDetails> patientDetailsListForDoctor(@PathVariable String doctorName) {
		return patientDetailsRepository.findPatientDetailsListForDoctor(doctorName);
	}

	//get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotAvailableException("Employee  does not exist with id" + id));
		return ResponseEntity.ok(employee);
	}

	//update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotAvailableException("Employee  does not exist with id" + id));
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setMobileNumber(employeeDetails.getMobileNumber());
		employee.setSpecialization(employeeDetails.getSpecialization());
		employee.setRole(employeeDetails.getRole());
		employee.setGender(employeeDetails.getGender());
		employee.setUserName(employeeDetails.getUserName());
		employee.setPassword(employeeDetails.getPassword());

		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotAvailableException("Employee  does not exist with id" + id));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	//creating patient
	@PostMapping("/createBooking")
	public BookingDetails createBooking(@RequestBody BookingDetails bookingDetails) {
		return bookingDetailsRepository.save(bookingDetails);
	}

	@GetMapping("/bookingInfo/{patientName}")
	public List<BookingDetails> retreivePatientBookingDetails(@PathVariable String patientName) {
		return bookingDetailsRepository.findByUserName(patientName);
	}

	@GetMapping("/bookingInfo/{reportingDoctor}/{specialization}")
	public List<BookingDetails> retreivePatientBookingForDoctor(@PathVariable String reportingDoctor, @PathVariable String specialization) {
		return bookingDetailsRepository.findByReportingDoctorAndSpecialization(reportingDoctor, specialization);
	}

	@GetMapping("/bookingInfo")
	public List<BookingDetails> retreivePatientBookingInfo() {
		return bookingDetailsRepository.findAll();
	}

	@GetMapping("/bookingInfoByDate/{reportingDoctor}/{specialization}")
	public List<BookingDetails> retreivePatientBookingInfo(@PathVariable String reportingDoctor, @PathVariable String specialization, @RequestParam Date dateOfBooking) {
		return bookingDetailsRepository.findByReportingDoctorAndSpecializationAndDateOfAppointment(reportingDoctor, specialization, dateOfBooking);
	}
}
