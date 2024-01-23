package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	// create student object, save student object, display id of the saved student

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student..");
		Student tempStudent = new Student("Lewis", "Hamilton", "lewis@amg.com");

		System.out.println("Saving student..");
		studentDAO.save(tempStudent);

		System.out.println("The student has been saved. Generated id: " + tempStudent.getId());
	}
}
