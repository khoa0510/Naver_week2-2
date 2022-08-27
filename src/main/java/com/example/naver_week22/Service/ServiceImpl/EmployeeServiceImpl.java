package com.example.naver_week22.Service.ServiceImpl;

import com.example.naver_week22.Entity.Department;
import com.example.naver_week22.Entity.Employee;
import com.example.naver_week22.Repository.DepartmentRepository;
import com.example.naver_week22.Repository.EmployeeRepository;
import com.example.naver_week22.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public Employee createEmployee(Long departmentId, Employee employee){
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        employee.setDepartment(optionalDepartment.get());
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeWithDepartment(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        return employeeOptional.orElse(null);
    }

    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        return employeeOptional.orElse(null);
    }

    public Employee updateEmployee(Long employeeId, Employee employee){
        employee.setEmployeeId(employeeId);
        employeeRepository.save(employee);
        return employee;
    }

    public String deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
        return "Delete complete";
    }
}
