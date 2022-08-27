package com.example.naver_week22.Repository;

import com.example.naver_week22.Entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Select("SELECT count(1) FROM DEPARTMENT")
    long count();
}

