package com.hospital.patient.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("HEALTH_RECORD")
@Getter
@Setter
public class HealthRecord extends PatientResource {
	private String diagnosis;
    private String prescriptions;
    
    
}
