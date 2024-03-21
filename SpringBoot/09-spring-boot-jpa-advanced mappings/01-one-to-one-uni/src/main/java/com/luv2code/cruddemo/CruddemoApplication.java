package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDao;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDao appDao) {

        return runner -> {
            // createInstructor(appDao);
            // findInstructor(appDao);
            deleteInstructor(appDao);
        };

    }

    private void deleteInstructor(AppDao appDao) {

        int id = 2;
        System.out.println("Deleting instructor id: " + id);

        appDao.deleteInstructorById(id);
        System.out.println("Instructor " + id + " deleted.");

    }

    private void findInstructor(AppDao appDao) {

        int id = 2;
        System.out.println("Finding instructor id: " + id);

        Instructor tempInstructor = appDao.findInstructorById(id);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("The associated instructorDetail: " + tempInstructor.getInstructorDetail());

    }

    private void createInstructor(AppDao appDao) {

        // create instructor
        Instructor instructor = new Instructor("Pedro", "Alves", "marega@goal.com");

        // create the instructor detail
        InstructorDetail instructorDetail = new InstructorDetail("http://www.codeWithMe.com/youtube", "padel");

        // associate the objects;
        instructor.setInstructorDetail(instructorDetail);

        // save the instructor
        // TODO this will also save the details object because of CascadeType.All
        System.out.println("Saving the instructor: " + instructor);
        appDao.save(instructor);
        System.out.println("Completed.");

        /*
        Instructor instructor = new Instructor("Luana", "Pinho", "madjer@goal.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.codeWithMe.com/youtube", "reading");
        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving the instructor: " + instructor);
        appDao.save(instructor);
        System.out.println("Completed.");*/
    }
}
