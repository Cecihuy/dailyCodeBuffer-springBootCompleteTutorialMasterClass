package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudent(){
        Student student = new Student();
        student.setEmailId("shabbir@gmail.com");
        student.setFirstName("Shabbir");
        student.setLastName("Dawoodi");
        student.setGuardianName("Nikhil");
        student.setGuardianEmail("nikhil@gmail.com");
        student.setGuardianMobile("99999");

        studentRepository.save(student);
    }

    @Test
    void printAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println("student list = " + students);
    }
}
