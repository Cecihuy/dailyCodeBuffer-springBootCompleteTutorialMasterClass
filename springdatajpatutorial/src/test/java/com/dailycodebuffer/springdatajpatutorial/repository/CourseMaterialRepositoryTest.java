package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    void saveCourseMaterial(){
        Course course = new Course();
        course.setTitle(".NET");
        course.setCredit(6);

        CourseMaterial courseMaterial = new CourseMaterial();
        courseMaterial.setUrl("www.dailycodebuffer.com");
        /* uncomment line below!!! */
        //courseMaterial.setCourse(course);

        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}
