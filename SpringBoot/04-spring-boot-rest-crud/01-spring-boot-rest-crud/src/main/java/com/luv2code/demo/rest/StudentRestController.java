package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        theStudents.add(new Student("Leo", "DiCaprio"));
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

        // check studentId against list size

        if( (studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }

        return  theStudents.get(studentId);
    }

    // add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return Response Entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // added another exception handler to catch any exceptions (all)
    @ExceptionHandler
    public  ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

