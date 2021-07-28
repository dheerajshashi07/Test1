package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "`INFO_HOSPITAL`")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "password")
	private String password;
	@Column(name = "userName")
	private String userName;

	@Column(name = "role")
	private String role;

	@Column(name = "Gender")
	private String gender;

	public Employee() {

	}

	public Employee(String emailId, String specialization, String mobileNumber, String password, String userName, String gender, String role) {
		super();
		this.emailId = emailId;
		this.specialization = specialization;
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.gender = gender;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
