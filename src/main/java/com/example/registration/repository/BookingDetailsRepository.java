package com.example.registration.repository;

import com.example.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
    public List<BookingDetails> findByUserName(String patientName);

    public List<BookingDetails> findByReportingDoctorAndSpecialization(String reportingDoctor, String specialization);

    public List<BookingDetails> findByReportingDoctorAndSpecializationAndDateOfAppointment(String reportingDoctor, String specialization, Date dateOfBooking);
}
