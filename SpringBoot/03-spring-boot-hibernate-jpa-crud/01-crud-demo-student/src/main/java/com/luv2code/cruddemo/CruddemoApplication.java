package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

			// createStudent(studentDAO);
			 createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryStudents(studentDAO);
			// queryStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students from database..");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + rowsDeleted + " rows from the database.");
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 5;

		System.out.println("Deleting student with Id: " + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the Id: PK
		int studentId = 1;
		System.out.println("Retrieving student with Id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name
		System.out.println("Updating..");
		myStudent.setFirstName("Max");

		// update the student
		studentDAO.update(myStudent);

		// print updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryStudentsByLastName(StudentDAO studentDAO){
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Ricc");

		// display list
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// STEPS: create student object, save student, display id, retrieve student based on id (PK), display student
		System.out.println("Creating new student..");
		Student tempStudent = new Student("Cristiano", "Ronaldo", "cristiano@cr7.pt");

		System.out.println("Saving student..");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student! Generated id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Student found.");
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 student objects..");
		Student tempStudent1 = new Student("Max", "Verstappen", "max@rbr.com");
		Student tempStudent2 = new Student("Dani", "Ricc", "big@ricc.com");
		Student tempStudent3 = new Student("Ayrton", "Senna", "ayrton@mclaren.com");

		System.out.println("Saving multiple students..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
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
