package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - returns list of all student, hardcoded for now

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Leo", "Di Caprio"));
        theStudents.add(new Student("Jack", "Nicholson"));
        theStudents.add(new Student("Denzel", "Washington"));

        return theStudents;

    }

}
