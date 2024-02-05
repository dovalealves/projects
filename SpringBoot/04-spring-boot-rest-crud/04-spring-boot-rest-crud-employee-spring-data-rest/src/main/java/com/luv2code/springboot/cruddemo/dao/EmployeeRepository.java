package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Extends Jpa Repo - employee as entity and integer (Id) as primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // no implementation required
}
