package com.example.naver_week22.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeWithDepartmentDTO {
    private Long employeeId;
    private String name;
    private Date birthDate;
    private String gender;
    private Long departmentId;
    private String dept_name;
    private String description;
}
