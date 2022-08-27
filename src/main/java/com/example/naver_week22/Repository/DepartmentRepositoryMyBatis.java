package com.example.naver_week22.Repository;

import com.example.naver_week22.Entity.Department;
import com.example.naver_week22.dto.DepartmentWithEmployeeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentRepositoryMyBatis {
    @Select("SELECT count(1) FROM EMPLOYEE WHERE department_id = #{id}")
    long count(Long id);

    @Select("SELECT d.department_id as departmentId, dept_name, description, count(e.employee_id) as count "+
    " FROM DEPARTMENT d, EMPLOYEE e " + "WHERE d.department_id = e.department_id AND d.department_id = #{id}")
    DepartmentWithEmployeeDTO findByDepartmentId(Long departmentId);


}
