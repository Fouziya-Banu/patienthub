package com.hospital.patient.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("APPOINTMENT")
@Getter
@Setter
public class Appointment extends PatientResource {
	private LocalDateTime appointmentDate;
    private String doctorName;
    
    
}
