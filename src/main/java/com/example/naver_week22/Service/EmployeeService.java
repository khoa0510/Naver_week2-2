package com.example.naver_week22.Service;

import com.example.naver_week22.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Long departmentId, Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeWithDepartment(Long employeeId);
    Employee getEmployeeById(Long employeeId);
    Employee updateEmployee(Long employeeId ,Employee employee);
    String deleteEmployee(Long employeeId);
}
