package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
    @Test
    void saveCourseWithTeacher(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Priyanka");
        teacher.setLastName("Singh");

        Course course = new Course();
        course.setTitle("Python");
        course.setCredit(6);
        course.setTeacher(teacher);

        courseRepository.save(course);
    }
    @Test
    void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        Integer totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }
    @Test
    void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("courses = " + courses);

    }
}
