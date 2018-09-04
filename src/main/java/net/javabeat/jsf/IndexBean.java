package net.javabeat.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class IndexBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String action() throws Exception {
		Thread.sleep(6000);
		System.out.println(message);
		return "";
	}

	public void saveMessage() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Successful",
				"Your message: " + message));
		context.addMessage(null, new FacesMessage("Second Message",
				"Additional Message Detail"));
	}

}