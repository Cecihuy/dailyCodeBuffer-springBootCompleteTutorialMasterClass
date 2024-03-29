package com.dailycodebuffer.springboottutorial.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.dailycodebuffer.springboottutorial.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    
    @BeforeEach
    void setUp(){
        Department department = new Department();
        department.setDepartmentName("Mechanical Engineering");
        department.setDepartmentAddress("Delhi");
        department.setDepartmentCode("ME - 011");

        testEntityManager.persist(department);
    }
    @Test
    void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1).get();
        assertEquals(department.getDepartmentName() , "Mechanical Engineering");
    }
}
