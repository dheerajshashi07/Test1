package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`BOOKING_DETAILS`")
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "reporting_doctor")
    private String reportingDoctor;
    @Column(name = "specialization")
    private String specialization;

    @Column(name = "date_of_appointment")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAppointment;

    @Column(name = "description")
    private String description;

    public BookingDetails() {

    }

    public BookingDetails(long id, String userName, String reportingDoctor, String specialization, Date dateOfAppointment, String description) {
        this.id = id;
        this.userName = userName;
        this.reportingDoctor = reportingDoctor;
        this.specialization = specialization;
        this.dateOfAppointment = dateOfAppointment;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReportingDoctor() {
        return reportingDoctor;
    }

    public void setReportingDoctor(String reportingDoctor) {
        this.reportingDoctor = reportingDoctor;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
