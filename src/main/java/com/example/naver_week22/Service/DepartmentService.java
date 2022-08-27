package com.example.naver_week22.Service;

import com.example.naver_week22.Entity.Department;
import com.example.naver_week22.dto.DepartmentWithEmployeeDTO;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(Long departmentId);
    DepartmentWithEmployeeDTO getDepartmentWithEmployee(Long departmentId);
    Department updateDepartment(Long departmentId, Department department);
    String deleteDepartment(Long departmentId);
}
