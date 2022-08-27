package com.example.naver_week22.Repository;

import com.example.naver_week22.Entity.Employee;
import com.example.naver_week22.dto.EmployeeWithDepartmentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeRepositoryMyBatis {
    @Select("SELECT employee_id as employeeId, name, birth_date, gender, d.department_id as departmentId, dept_name, description "+
            " FROM EMPLOYEE e, DEPARTMENT d "+" WHERE d.department_id = e.department_id AND employee_id = #{id}")
    EmployeeWithDepartmentDTO findByEmployeeId(Long employeeId);
}
