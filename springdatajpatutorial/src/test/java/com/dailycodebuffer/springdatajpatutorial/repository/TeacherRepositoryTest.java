package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher(){
        Course courseDBA = new Course();
        courseDBA.setTitle("DBA");
        courseDBA.setCredit(5);

        Course courseJava = new Course();
        courseJava.setTitle("Java");
        courseJava.setCredit(6);

        Teacher teacher = new Teacher();
        teacher.setFirstName("Qutub");
        teacher.setLastName("Khan");
        teacher.setCourses(List.of(courseDBA, courseJava));

        teacherRepository.save(teacher);
    }
}
