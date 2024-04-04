package com.dailycodebuffer.springdatajpatutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}