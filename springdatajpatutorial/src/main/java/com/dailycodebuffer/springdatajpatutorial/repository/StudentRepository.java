package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
}