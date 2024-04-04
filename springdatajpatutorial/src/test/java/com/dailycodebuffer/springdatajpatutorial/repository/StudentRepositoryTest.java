package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dailycodebuffer.springdatajpatutorial.entity.Guardian;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    
    @Test
    void saveStudentWithGuardian(){
        Guardian guardian = new Guardian();
        guardian.setName("Nikhil");
        guardian.setEmail("nikhil@gmail.com");
        guardian.setMobile("9999999");

        Student student = new Student();
        student.setFirstName("Shivam");
        student.setEmailId("shivam@gmail.com");
        student.setLastName("Kumar");
        student.setGuardian(guardian);

        studentRepository.save(student);
    }
    @Test
    void printAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println("student list = " + students);
    }
    @Test
    void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Shivam");
        System.out.println("students = " + students);
    }
    @Test
    void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Sh");
        System.out.println("students = " + students);
    }
    @Test
    void printStudentByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }
    @Test
    void printStudentBaseOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = " + students);
    }
}
