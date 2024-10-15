package com.neoteric.springdemoproject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id",nullable = false)
    private String employeeId;  // Employee ID shown in your table

    @Column(name = "name")
    private String name;  // Employee Name

    @Column(name = "date_employed")
    private String dateEmployed;  // Date of employment (format: yyyy-MM-dd)

    @Column(name = "job_type")
    private String jobType;  // Job type as displayed in the UI

    @Column(name = "status")
    private String status;  // Employee status (e.g., "employee")
}
