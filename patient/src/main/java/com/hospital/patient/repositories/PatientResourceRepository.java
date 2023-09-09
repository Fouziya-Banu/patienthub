package com.hospital.patient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.patient.entities.PatientResource;

@Repository
public interface PatientResourceRepository extends JpaRepository<PatientResource, Long> {

}
