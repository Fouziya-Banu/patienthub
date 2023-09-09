package com.hospital.patient.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("EMERGENCY_CONTACT")
@Getter
@Setter
public class EmergencyContact extends PatientResource {
	private String name;
    private String phoneNumber;
    
    
}
