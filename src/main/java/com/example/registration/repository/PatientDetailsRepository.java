package com.example.registration.repository;

import com.example.model.PatientDetails;

import java.util.List;

public interface PatientDetailsRepository {
    List<PatientDetails> findAll();

    List<PatientDetails> findPatientDetailsListForDoctor(String doctorName);

    PatientDetails findByEmailIdAndPasswordAndRole(String emailId, String password, String role);

    int save(PatientDetails patientDetails);
}
