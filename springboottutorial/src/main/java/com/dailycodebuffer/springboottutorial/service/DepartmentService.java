package com.dailycodebuffer.springboottutorial.service;
import java.util.List;
import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.error.DepartmentNotFoundException;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList();
    Department findDepartmentById(Integer deptId) throws DepartmentNotFoundException;
    void deleteDepartmentById(Integer deptId);
    Department updateDepartment(Department department, Integer deptId);
    Department fetchDepartmentByName(String deptName);
}