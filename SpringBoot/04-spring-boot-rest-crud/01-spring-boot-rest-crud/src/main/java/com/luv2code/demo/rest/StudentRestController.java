package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ONLY ONCE.

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Leo", "Di Caprio"));
        theStudents.add(new Student("Jack", "Nicholson"));
        theStudents.add(new Student("Denzel", "Washington"));
    }

    // define endpoint for "/students" - returns list of all student, hardcoded for now

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint "/students/{studentId" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list, keeping it simple

        return  theStudents.get(studentId);
    }

}
