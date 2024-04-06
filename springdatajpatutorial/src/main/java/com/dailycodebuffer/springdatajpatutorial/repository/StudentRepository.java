package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    @Query(value = "select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);
    @Query(value = "select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);
}