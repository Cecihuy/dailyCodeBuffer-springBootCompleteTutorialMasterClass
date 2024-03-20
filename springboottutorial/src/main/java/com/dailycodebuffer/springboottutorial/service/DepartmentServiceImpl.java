package com.dailycodebuffer.springboottutorial.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }
}
