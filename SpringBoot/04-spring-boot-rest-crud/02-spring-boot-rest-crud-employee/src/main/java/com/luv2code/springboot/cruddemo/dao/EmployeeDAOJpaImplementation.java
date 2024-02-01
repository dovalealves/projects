package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO {

    // define field for EntityManager

    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImplementation(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the list/result
        return employees;
    }

    // add, save, delete methods
    @Override
    public Employee findById(int Id) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class, Id);
        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save the employee - merge saves or updates depending on the id of the entity - if id == 0 add, else save
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int Id) {

        // delete the employee
        Employee dbEmployee = entityManager.find(Employee.class, Id);

        // remove
        entityManager.remove(dbEmployee);

    }
}
