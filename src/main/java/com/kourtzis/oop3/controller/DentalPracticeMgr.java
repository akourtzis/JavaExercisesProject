package com.kourtzis.oop3.controller;

import java.util.TreeSet;
import java.util.UUID;
import java.util.Set;

import com.kourtzis.oop3.model.HealthInsurance;
import com.kourtzis.oop3.model.Patient;

import lombok.Getter;

@Getter
public class DentalPracticeMgr {
    private Set<HealthInsurance> healthInsurances;

    public DentalPracticeMgr(final Set<HealthInsurance> healthInsurances) {
        this.healthInsurances = healthInsurances;
    }

    public boolean addInsurance(final String name, final String number) {
        Set<Patient> patients = new TreeSet<>(); 
        HealthInsurance insurance = new HealthInsurance(name, number, patients);
        
        return addInsurance(insurance);
    }

    public boolean addInsurance(final HealthInsurance healthInsurance) {
        if(healthInsuranceExists(healthInsurance)) {
            return false;
        }
        else {
            healthInsurances.add(healthInsurance);
            return true;
        }
    }
    
    public boolean addPatient(final String name, final String insuranceName) {
        final String id = getNewId();
        Patient patient = new Patient(id, name);
        HealthInsurance insurance = findInsurance(insuranceName);

        return insurance.getPatients().add(patient);
    }

    public boolean healthInsuranceExists(final HealthInsurance healthInsurance) {
        return healthInsurances.contains(healthInsurance);
    }

    public String getNewId() {
        return UUID.randomUUID().toString();
    }

    public HealthInsurance findInsurance(final String name) {
        for(HealthInsurance insurance: healthInsurances) {
            if(insurance.getHealthInsuranceName().equalsIgnoreCase(name)) {
                return insurance;
            }
        }

        final String insuranceNumber = getNewId();
        return new HealthInsurance(name, insuranceNumber, new TreeSet<Patient>());
    }
}