package com.example.naver_week22.Service.ServiceImpl;

import com.example.naver_week22.Entity.Department;
import com.example.naver_week22.Repository.DepartmentRepository;
import com.example.naver_week22.Repository.DepartmentRepositoryMyBatis;
import com.example.naver_week22.Service.DepartmentService;
import com.example.naver_week22.dto.DepartmentWithEmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Resource
    DepartmentRepositoryMyBatis departmentRepositoryMyBatis;

    @Autowired
    ModelMapper modelMapper;

    public Department createDepartment(Department department){
        departmentRepository.save(department);
        return department;
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    public DepartmentWithEmployeeDTO getDepartmentWithEmployee(Long departmentId) {
        //Department department = departmentRepositoryMyBatis.findByDepartmentId(departmentId);
        //Long count = departmentRepositoryMyBatis.count(departmentId);
        //DepartmentWithEmployeeDTO departmentDTO = modelMapper.map(department, DepartmentWithEmployeeDTO.class);
        //departmentDTO.setCount(count);
        return departmentRepositoryMyBatis.findByDepartmentId(departmentId);
    }

    public Department updateDepartment(Long departmentId, Department department){
        department.setDepartmentId(departmentId);
        departmentRepository.save(department);
        return department;
    }

    public String deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);
        return "Delete complete";
    }
}
