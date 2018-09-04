package com.logicbig.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean
@RequestScoped
@Component
public class EmployeeBean {
	
	@Autowired
    EmployeeLazyDataModel dataModel;// = new EmployeeLazyDataModel();

    public LazyDataModel<Employee> getModel(){
        return dataModel;
    }
}