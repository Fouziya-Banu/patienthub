package com.hospital.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hospital.patient.exception.ResourceNotFoundException;
import com.hospital.patient.entities.PatientResource;
import com.hospital.patient.repositories.PatientResourceRepository;

@Service
public class PatientResourceService {
	
	@Autowired
	private PatientResourceRepository repository;

    public PatientResourceService(PatientResourceRepository repository) {
        this.repository = repository;
    }

    @Cacheable("patients")
    public List<PatientResource> getAllPatients() {
        return repository.findAll();
    }

    @Cacheable("patient")
    public PatientResource getPatientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
    }

    @CacheEvict(value = { "patients", "patient" }, allEntries = true)
    public PatientResource createPatient(PatientResource patient) {
        return repository.save(patient);
    }

    @CacheEvict(value = { "patients", "patient" }, allEntries = true)
    public PatientResource updatePatient(Long id, PatientResource updatedPatient) {
        PatientResource existingPatient = getPatientById(id);
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setCondition(updatedPatient.getCondition());
        return repository.save(existingPatient);
    }

    @CacheEvict(value = { "patients", "patient" }, allEntries = true)
    public void deletePatient(Long id) {
        getPatientById(id);
        repository.deleteById(id);
    }

}
