package com.kourtzis.oop3.model;

import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"healthInsuranceNumber"})
public class HealthInsurance {
    private Set<Patient> patients;
    private String healthInsuranceNumber;
    private String healthInsuranceName;

    public HealthInsurance(final String healthInsuranceName, final String healthInsuranceNumber, final Set<Patient> patients) {
        this.healthInsuranceNumber = healthInsuranceNumber;
        this.healthInsuranceName = healthInsuranceName;

        this.patients = patients;
    }

    public boolean addPatient(final Patient patient) {
        patients.add(patient);
        return true;
    }

    public Patient getPatient(final String patientId) {
        for(Patient patient: patients) {
            if(patient.getId().equals(patientId)) {
                return new Patient(patient);
            }
        }

        return null;
    }
}
