package com.jsf.bootstrap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StudentBean {

	private String firstName;
	private String lastName;
	private String standard;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String createStudentForm() {
		System.out.println("Reading Student Details - Name: " + firstName + " " + lastName + ", Standard: " + standard);
		return "prmface/output";
	}
	
	 public void saveMessage() {
	        FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Successful",  "Your message: ") );
	        /*context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));*/
	 }
}