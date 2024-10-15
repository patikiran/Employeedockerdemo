package com.neoteric.springdemoproject.service;

import com.neoteric.springdemoproject.Entity.Employee;
import com.neoteric.springdemoproject.dto.EmployeeDTO;
import com.neoteric.springdemoproject.mapper.EmployeeMapper;
import com.neoteric.springdemoproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee != null ? EmployeeMapper.toDTO(employee) : null;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(savedEmployee);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName());
            employee.setDateEmployed(employeeDetails.getDateEmployed());
            employee.setJobType(employeeDetails.getJobType());
            employee.setStatus(employeeDetails.getStatus());
            Employee updatedEmployee = employeeRepository.save(employee);
            return EmployeeMapper.toDTO(updatedEmployee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
