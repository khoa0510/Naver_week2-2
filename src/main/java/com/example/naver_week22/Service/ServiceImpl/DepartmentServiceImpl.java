package com.example.naver_week22.Service.ServiceImpl;

import com.example.naver_week22.Entity.Department;
import com.example.naver_week22.Repository.DepartmentRepository;
import com.example.naver_week22.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department createDepartment(Department department){
        departmentRepository.save(department);
        return department;
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    public Department getDepartmentWithEmployee(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    public Department updateDepartment(Long departmentId, Department department){
        department.setDepartmentId(departmentId);
        departmentRepository.save(department);
        return department;
    }

    public String deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);
        return "Delete complete";
    }
}
