package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
