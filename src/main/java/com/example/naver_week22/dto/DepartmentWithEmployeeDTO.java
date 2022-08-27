package com.example.naver_week22.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentWithEmployeeDTO {
    private Long departmentId;
    private String dept_name;
    private String description;
    private Long count;
}
