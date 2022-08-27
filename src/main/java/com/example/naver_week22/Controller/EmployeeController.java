package com.example.naver_week22.Controller;

import com.example.naver_week22.Entity.Employee;
import com.example.naver_week22.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping("/{employeeId}/more_info")
    public ResponseEntity<?> getEmployeeWithDepartment(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeWithDepartment(employeeId));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId,
                                                   @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId ,employee));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }
}
