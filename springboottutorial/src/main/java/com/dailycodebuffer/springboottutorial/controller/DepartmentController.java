package com.dailycodebuffer.springboottutorial.controller;
import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboottutorial.service.DepartmentService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =  LoggerFactory.getLogger(DepartmentController.class);

    @RequestMapping(path = "/departments", method = RequestMethod.POST)
    public Department saveDepartment(@RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @RequestMapping(path = "/departments", method = RequestMethod.GET)
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }
    @RequestMapping(path = "/departments/{id}", method = RequestMethod.GET)
    public Department findDepartmentById(@PathVariable(name = "id") Integer deptId) throws DepartmentNotFoundException{
        return departmentService.findDepartmentById(deptId);
    }
    @RequestMapping(path = "/departments/{id}", method = RequestMethod.DELETE)
    public String deleteDepartmentById(@PathVariable(name = "id") Integer deptId){
        departmentService.deleteDepartmentById(deptId);
        return "Department deleted successfully!!!";
    }
    @RequestMapping(path = "/departments/{id}", method = RequestMethod.PUT)
    public Department updateDepartment(@RequestBody Department department, @PathVariable(name = "id") Integer deptId){
        return departmentService.updateDepartment(department, deptId);
    }
    @RequestMapping(path = "/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable(name = "name") String deptName){
        return departmentService.fetchDepartmentByName(deptName);
    }
}