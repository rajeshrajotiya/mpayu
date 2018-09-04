package com.logicbig.example;

import org.fluttercode.datafactory.impl.DataFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public enum DataService {
    INSTANCE;
    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("employee-unit");

    DataService(){
        //persisting some data in database
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        DataFactory dataFactory = new DataFactory();
        for (int i = 1; i < 100; i++) {
            Employee employee = new Employee();
            employee.setName(dataFactory.getName());
            employee.setPhoneNumber(String.format("%s-%s-%s", dataFactory.getNumberText(3),
                    dataFactory.getNumberText(3),
                    dataFactory.getNumberText(4)));
            employee.setAddress(dataFactory.getAddress() + "," + dataFactory.getCity());
            em.persist(employee);
        }

        em.getTransaction().commit();
        em.close();
    }

    public List<Employee> getEmployeeList(int start, int size){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("From Employee");
        query.setFirstResult(start);
        query.setMaxResults(size);
        List <Employee> list = query.getResultList();
        return list;
    }

    public int getEmployeeTotalCount() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select count(e.id) From Employee e");
        return ((Long)query.getSingleResult()).intValue();
    }
}