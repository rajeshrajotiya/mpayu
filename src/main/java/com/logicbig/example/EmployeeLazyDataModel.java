package com.logicbig.example;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeLazyDataModel extends LazyDataModel<Employee> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1780102534969503839L;
	
	
	@Autowired
	MyDataService myDataService;
	

    public EmployeeLazyDataModel(){
    	
    	if(myDataService==null){
    		System.out.println("#############myDataServicemyDataServicemyDataServicemyDataServicemyDataServicemyDataService");
    	}
    	
       // System.out.println("--------- "+this+" -----------------size="+myDataService.getEmployeeTotalCount());
       /* this.setRowCount(DataService.INSTANCE.getEmployeeTotalCount());*/
        
        // this.setRowCount(myDataService.getEmployeeTotalCount());
        
    }
    
    
    @Override
    public List<Employee> load(int first, int pageSize, String sortField,SortOrder sortOrder, Map<String, Object> filters) {

       /* List<Employee> list = DataService.INSTANCE.getEmployeeList(first, pageSize);*/
    	
    	
    	List<Employee> list =myDataService.getEmployeeList(first, pageSize, sortField, sortOrder,filters);
    	
    	this.setRowCount(myDataService.getTotalEmployeeList());
    	
    	System.out.println("employee size="+list.size()+" list="+list.toString());
    			
    	 
        return list;
    }
}