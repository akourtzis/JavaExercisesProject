package com.kourtzis.oop3.model;

import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(of = { "id"})
public class Patient {
    private String id;
    private String name;
    private String address;
    private Date birthday;
    private String insuranceName;
    private boolean insuranceCardPresent;

    public Patient(final String id, 
                   final String name, 
                   final String address, 
                   final Date birthday, 
                   final String insuranceName, 
                   boolean insuranceCardPresent) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.insuranceName = insuranceName;
        this.insuranceCardPresent = insuranceCardPresent;            
    }

    public Patient(final Patient rhs) {
        this(rhs.getId(), 
             rhs.getName(), 
             rhs.getAddress(), 
             rhs.getBirthday(), 
             rhs.getInsuranceName(), 
             rhs.isInsuranceCardPresent()); 
    }

    public Patient(final String id, final String name) {
        this(id, name, "", null, name, true);
    }
}