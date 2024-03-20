package com.dailycodebuffer.springboottutorial.service;
import java.util.List;
import com.dailycodebuffer.springboottutorial.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList();
}
