package com.dailycodebuffer.springboottutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dailycodebuffer.springboottutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
}