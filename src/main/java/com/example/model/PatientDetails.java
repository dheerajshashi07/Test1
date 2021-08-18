package com.example.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`PATIENT_DETAILS`")
public class PatientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email_id")
    private String emailId;

    @Column(name = "reporting_doctor")
    private String reportingDoctor;

    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "role")
    private String role;
    @Column(name = "gender")
    private String gender;

    public PatientDetails() {

    }

    public PatientDetails(long id, String emailId, String reportingDoctor, String mobileNumber, String password, String userName, String role, String gender) {
        super();
        this.id = id;
        this.emailId = emailId;
        this.reportingDoctor = reportingDoctor;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.userName = userName;
        this.role = role;
        this.gender = gender;
    }


    public PatientDetails(long id, String emailId, String mobileNumber, String userName, String gender) {
        this.id = id;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.gender = gender;
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

    public String getReportingDoctor() {
        return reportingDoctor;
    }

    public void setReportingDoctor(String reportingDoctor) {
        this.reportingDoctor = reportingDoctor;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientDetails)) return false;
        PatientDetails that = (PatientDetails) o;
        return getId() == that.getId() && Objects.equals(getEmailId(), that.getEmailId()) && Objects.equals(getReportingDoctor(), that.getReportingDoctor()) && Objects.equals(getMobileNumber(), that.getMobileNumber()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getGender(), that.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmailId(), getReportingDoctor(), getMobileNumber(), getPassword(), getUserName(), getGender());
    }
}
