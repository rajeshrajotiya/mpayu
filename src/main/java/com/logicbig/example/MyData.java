package com.logicbig.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MyData implements MyDataService {
	
	/*
	 * private final EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("employee-unit");
	 */

	 @Autowired
	 private SessionFactory sessionFactory;
	

	/*DataService() {
		// persisting some data in database

		sessionFactory.getCurrentSession().beginTransaction();

		DataFactory dataFactory = new DataFactory();
		for (int i = 1; i < 100; i++) {
			Employee employee = new Employee();
			employee.setName(dataFactory.getName());
			employee.setPhoneNumber(String.format("%s-%s-%s",
					dataFactory.getNumberText(3), dataFactory.getNumberText(3),
					dataFactory.getNumberText(4)));
			employee.setAddress(dataFactory.getAddress() + ","
					+ dataFactory.getCity());
			sessionFactory.getCurrentSession().persist(employee);
		}

		sessionFactory.getCurrentSession().getTransaction().commit();
		sessionFactory.getCurrentSession().close();
	}*/

	public List<Employee> getEmployeeList(int start, int size,String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		List<Employee> emplist=new ArrayList<Employee>();
		
		/*CriteriaBuilder cb = sessionFactory.getCurrentSession()
				.getCriteriaBuilder();

		CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
		Root<Employee> r = q.from(Employee.class);
		CriteriaQuery<Employee> select = q.select(r);
		if (sortField != null) {
			q.orderBy(sortOrder == SortOrder.DESCENDING ? cb.asc(r
					.get(sortField)) : cb.desc(r.get(sortField)));
		}

		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(select);
		query.setFirstResult(start);
		query.setMaxResults(size);*/
		//List<Employee> list = query.getResultList();
		
       Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		
		/*if(sortField!=null && !sortField.equals("")){
			sortField = sortField.trim();
			  criteria.add(Restrictions.like("name", "%"+sortField+"%").ignoreCase());
				
		}*/
       
       
       if (filters != null) {
           for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
               try {
                   String filterProperty = it.next();
                   Object filterValue = filters.get(filterProperty);
                   
                   System.out.println("filterProperty="+filterProperty+" filterValue="+filterValue);
                   
                   if(filterProperty!=null && !filterProperty.equals("") && filterValue!=null && !filterValue.equals("")){
                	   
	           			  
	           			  criteria.add(Restrictions.like(filterProperty, "%"+filterValue+"%").ignoreCase());
           				
           		   }

               } catch(Exception e) {
                   
               }
           }
       }
       
       
         System.out.println("sortOrdersortOrdersortOrdersortOrdersortOrdersortOrdersortOrder="+sortOrder);
         System.out.println("sortFieldsortFieldsortFieldsortFieldsortFieldsortFieldsortField="+sortField);
		
         if(sortField!=null){
			 if (SortOrder.ASCENDING.equals(sortOrder)){
				 criteria.addOrder(Order.asc(sortField));
			 }else{
				 criteria.addOrder(Order.desc(sortField));
			 }
         }
		
		criteria.setFirstResult(start);// off set
		criteria.setMaxResults(size); // limit
		
		 emplist=criteria.list();
		 
		 List<Employee> tempList=new ArrayList<Employee>();
		 
		 for(Employee emp:emplist){
			 
			 String action="<a title='Edit' href='./edithospital.do?id="+emp.getId()+"'><i class='fa fa-edit' style='font-size:16px;color:green'></i></a>"
						+ " <a title='delete' href='./deletehospital.do?id="+emp.getId()+"'><i class='fa fa-trash-o' style='font-size:16px;color:red'></i></a>";
				
			 emp.setAction(action);
			 
			 tempList.add(emp);
		 }
		
		
		
//		return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		
		return tempList;
	}

	public int getEmployeeTotalCount() {
		
		
		/*System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		if(sessionFactory==null){
			System.out.println("nullnullnullnullnullnullnullnullnullnullnull");
		}
		
		
		List list =sessionFactory.getCurrentSession().createQuery("from User").list();
		
		System.out.println("listlist="+list.size());
		
		

		Query query =  (Query) sessionFactory.getCurrentSession().createQuery("Select count(e.id) From Employee e");
		return ((Long) query.getSingleResult()).intValue();*/
		
		return 10;
		
	}

	public int getTotalEmployeeList() {
		
		List<Employee> emplist=new ArrayList<Employee>();
		
		    Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
			
			/*if(sortField!=null && !sortField.equals("")){
				sortField = sortField.trim();
				  criteria.add(Restrictions.like("name", "%"+sortField+"%").ignoreCase());
					
			}*/
			
			/* if (SortOrder.ASCENDING.equals(sortOrder)){
				 criteria.addOrder(Order.asc(sortField));
			 }else{
				 criteria.addOrder(Order.desc(sortField));
			 }*/
			
			 emplist=criteria.list();
			
			return emplist.size();
	}
}