package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get the employee from the DB
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

        // get the employee from the service
        Employee employee = employeeService.findById(id);

        // set employee in the model to prepopulate form
        model.addAttribute("employee", employee);

        // send over to form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // save the employee
        employeeService.save(employee);

        // use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {

        //delete the employee
        employeeService.deleteById(id);

        // redirect to the /employees/list-employees
        return "redirect:/employees/list";
        
    }
}
