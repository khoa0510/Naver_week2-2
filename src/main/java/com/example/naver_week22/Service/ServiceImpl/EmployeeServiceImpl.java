package com.example.naver_week22.Service.ServiceImpl;

import com.example.naver_week22.Entity.Department;
import com.example.naver_week22.Entity.Employee;
import com.example.naver_week22.Repository.DepartmentRepository;
import com.example.naver_week22.Repository.DepartmentRepositoryMyBatis;
import com.example.naver_week22.Repository.EmployeeRepository;
import com.example.naver_week22.Repository.EmployeeRepositoryMyBatis;
import com.example.naver_week22.Service.EmployeeService;
import com.example.naver_week22.dto.EmployeeWithDepartmentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Resource
    EmployeeRepositoryMyBatis employeeRepositoryMyBatis;
    @Resource
    DepartmentRepositoryMyBatis departmentRepositoryMyBatis;

    @Autowired
    ModelMapper mapper;

    public Employee createEmployee(Long departmentId, Employee employee){
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        employee.setDepartment(optionalDepartment.get());
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeWithDepartmentDTO getEmployeeWithDepartment(Long employeeId) {
        //Employee employee = employeeRepositoryMyBatis.findByEmployeeId(employeeId);
        //Department department = departmentRepositoryMyBatis.findByDepartmentId(employee.getDepartment().getDepartmentId());
        //EmployeeWithDepartmentDTO employeeDTO = mapper.map(employee, EmployeeWithDepartmentDTO.class);
        //mapper.map(department, employeeDTO);
        return employeeRepositoryMyBatis.findByEmployeeId(employeeId);
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
