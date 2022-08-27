package com.example.naver_week22.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DEPARTMENT")
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "departmentId", nullable = false)
    private Long departmentId;

    @Column(name = "dept_name", nullable = false)
    private String dept_name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();
}
