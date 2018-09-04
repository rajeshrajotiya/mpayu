package com.logicbig.example;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

public interface MyDataService {
	
	public List<Employee> getEmployeeList(int start, int size,String sortField, SortOrder sortOrder,  Map<String, Object> filters);
	public int getTotalEmployeeList();
	
	public  int getEmployeeTotalCount();

}
