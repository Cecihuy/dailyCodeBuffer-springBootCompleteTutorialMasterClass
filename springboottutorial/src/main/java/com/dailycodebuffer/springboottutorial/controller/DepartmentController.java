package com.dailycodebuffer.springboottutorial.controller;
import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.service.DepartmentService;
import java.util.List;
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

    @RequestMapping(path = "/departments", method = RequestMethod.POST)
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @RequestMapping(path = "/departments", method = RequestMethod.GET)
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @RequestMapping(path = "/departments/{id}", method = RequestMethod.GET)
    public Department findDepartmentById(@PathVariable(name = "id") Integer deptId){
        return departmentService.findDepartmentById(deptId);
    }
}