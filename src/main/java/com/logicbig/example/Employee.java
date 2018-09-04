package com.logicbig.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Employee {
    @Id
    @SequenceGenerator(name = "eSGen", sequenceName = "employeeSeq",initialValue = 50)
    @GeneratedValue(generator = "eSGen")
    private long id;
    private String name;
    private String phoneNumber;
    private String address;
    
    @Transient
    private String action;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    
    
}