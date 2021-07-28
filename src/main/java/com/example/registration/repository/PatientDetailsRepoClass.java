package com.example.registration.repository;

import com.example.model.PatientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PatientDetailsRepoClass implements PatientDetailsRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PatientDetails> findAll() {
        return namedParameterJdbcTemplate.query("select * from patient_details",
                (rs, rowNum) ->
                        new PatientDetails(
                                rs.getLong("id"),
                                rs.getString("email_id"),
                                rs.getString("mobile_number"),
                                rs.getString("user_name"),
                                rs.getString("gender")
                        )
        );
    }

    public List<PatientDetails> findPatientDetailsListForDoctor(String doctorName) {
        return namedParameterJdbcTemplate.query("select * from patient_details where reporting_doctor = :doctorName",
                new MapSqlParameterSource("doctorName", doctorName),
                (rs, rowNum) ->
                        new PatientDetails(
                                rs.getLong("id"),
                                rs.getString("email_id"),
                                rs.getString("mobile_number"),
                                rs.getString("user_name"),
                                rs.getString("gender")
                        )
        );
    }


    public PatientDetails findByEmailIdAndPasswordAndRole(String emailId, String password, String role) {
        MapSqlParameterSource params1 = new MapSqlParameterSource();
        params1.addValue("role", role);
        params1.addValue("emailId", emailId);
        params1.addValue("password", password);

        return namedParameterJdbcTemplate.query("select * from patient_details where role = :role and email_id = :emailId and password = :password",
                params1,
                new ResultSetExtractor<PatientDetails>() {

                    @Override
                    public PatientDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            PatientDetails contact = new PatientDetails();
                            contact.setId(rs.getInt("id"));
                            contact.setEmailId(rs.getString("email_id"));
                            contact.setMobileNumber(rs.getString("mobile_number"));
                            contact.setUserName(rs.getString("user_name"));
                            contact.setGender(rs.getString("gender"));
                            return contact;
                        }
                        return null;
                    }

                });
    }

    @Override
    public int save(PatientDetails patientDetails) {
        return jdbcTemplate.update(
                "insert into patient_details (id, email_id, reporting_doctor, mobile_number,password,user_name,role,gender) values(?,?,?,?,?,?,?,?)",
                patientDetails.getId(), patientDetails.getEmailId(), patientDetails.getReportingDoctor(), patientDetails.getMobileNumber(), patientDetails.getPassword(), patientDetails.getUserName(), patientDetails.getRole(), patientDetails.getGender());
    }
}
