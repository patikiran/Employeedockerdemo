package com.neoteric.springdemoproject.mapper;

import com.neoteric.springdemoproject.Entity.Employee;
import com.neoteric.springdemoproject.dto.EmployeeDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getDateEmployed().formatted(formatter),
                employee.getJobType(),
                employee.getStatus()
        );
    }

    public static Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setName(employeeDTO.getName());
        employee.setDateEmployed(employeeDTO.getDateEmployed());
        employee.setJobType(employeeDTO.getJobType());
        employee.setStatus(employeeDTO.getStatus());
        return employee;
    }

}
