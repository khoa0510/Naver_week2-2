package com.example.naver_week22.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "employeeId", nullable = false)
    private Long employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;
}
