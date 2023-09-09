package com.hospital.patient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.patient.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
