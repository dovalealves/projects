package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        // create student
        Student student = new Student();

        // add student to the model
        theModel.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // log input data for debugging
        System.out.println("theStudent: " + theStudent.getFirstName() + "  " + theStudent.getLastName());

        return "student-confirmation";
    }
}
