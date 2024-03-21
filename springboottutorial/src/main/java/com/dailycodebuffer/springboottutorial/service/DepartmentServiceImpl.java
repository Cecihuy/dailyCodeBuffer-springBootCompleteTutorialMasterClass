package com.dailycodebuffer.springboottutorial.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.error.DepartmentNotFoundException;
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
    @Override
    public Department findDepartmentById(Integer deptId) throws DepartmentNotFoundException{
        Optional<Department> department = departmentRepository.findById(deptId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }
    @Override
    public void deleteDepartmentById(Integer deptId) {
        departmentRepository.deleteById(deptId);
    }
    @Override
    public Department updateDepartment(Department department, Integer deptId) {
        Department departmentLocal = departmentRepository.findById(deptId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentLocal.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentLocal.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentLocal.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(departmentLocal);
    }
    @Override
    public Department fetchDepartmentByName(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
    }
}