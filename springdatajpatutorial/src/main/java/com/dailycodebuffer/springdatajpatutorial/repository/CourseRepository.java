package com.dailycodebuffer.springdatajpatutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dailycodebuffer.springdatajpatutorial.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
