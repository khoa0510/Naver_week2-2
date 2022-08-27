package com.example.naver_week22.Controller;

import com.example.naver_week22.Entity.Department;
import com.example.naver_week22.Entity.Employee;
import com.example.naver_week22.Service.DepartmentService;
import com.example.naver_week22.Service.EmployeeService;
import com.example.naver_week22.dto.DepartmentWithEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.createDepartment(department));
    }

    @GetMapping("")
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") Long departmentId,
                                                       @RequestBody Department department) {
        return ResponseEntity.ok(departmentService.updateDepartment(departmentId ,department));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Long departmentId) {
        return ResponseEntity.ok(departmentService.deleteDepartment(departmentId));
    }

    @GetMapping("/{departmentId}/employee")
    public ResponseEntity<DepartmentWithEmployeeDTO> getDepartmentWithEmployee(@PathVariable("departmentId") Long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentWithEmployee(departmentId));
    }

    @PostMapping("/{departmentId}/employee")
    public ResponseEntity<Employee> createEmployee(@PathVariable("departmentId") Long departmentId,
                                                   @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(departmentId, employee));
    }
}
