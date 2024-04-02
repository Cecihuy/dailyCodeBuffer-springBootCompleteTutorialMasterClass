package com.dailycodebuffer.springboottutorial.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.service.DepartmentService;

@WebMvcTest(value = DepartmentController.class)
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    Department department = new Department();

    @BeforeEach
    void setUp(){
        department.setDepartmentAddress("Ahmedabad");
        department.setDepartmentCode("IT-06");
        department.setDepartmentName("IT");
        department.setDepartmentId(1);
    }
    @Test
    void testFindDepartmentById() throws Exception {

        Mockito.when(departmentService.findDepartmentById(1))
            .thenReturn(department);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                .value(department.getDepartmentName()));
    }
    @Test
    void testSaveDepartment() throws Exception {
        Department inputDepartment = new Department();
        inputDepartment.setDepartmentAddress("Ahmedabad");
        inputDepartment.setDepartmentCode("IT-06");
        inputDepartment.setDepartmentName("IT");
        inputDepartment.setDepartmentId(1);

        Mockito.when(departmentService.saveDepartment(inputDepartment))
            .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"departmentName\":\"IT\"," +
                "\"departmentAddress\":\"Ahmedabad\"," +
                "\"departmentCode\":\"IT-06\"" +
                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());            
    }
}
