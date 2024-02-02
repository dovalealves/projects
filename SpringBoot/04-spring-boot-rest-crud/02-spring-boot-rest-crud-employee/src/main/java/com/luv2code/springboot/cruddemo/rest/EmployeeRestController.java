package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" endpoint and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee Id not found - " + employeeId);
        }

        return employee;
    }

    // add mapping for POST /employees/{employeeId}

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // just in case they pass an id in JSON, set id to 0 -- this is to force a save of the new item instead of update
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

}
