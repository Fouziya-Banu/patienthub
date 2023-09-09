package com.hospital.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patient.entities.PatientResource;
import com.hospital.patient.service.PatientResourceService;

@RestController
@RequestMapping("/patients")
public class PatientResourceController {
	
	@Autowired
	private PatientResourceService service;

    public PatientResourceController(PatientResourceService service) {
        this.service = service;
    }

    @GetMapping
    public List<PatientResource> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientResource getPatient(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @PostMapping
    public PatientResource createPatient(@RequestBody PatientResource patient) {
        return service.createPatient(patient);
    }

    @PutMapping("/{id}")
    public PatientResource updatePatient(@PathVariable Long id, @RequestBody PatientResource updatedPatient) {
        return service.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
    }

}
