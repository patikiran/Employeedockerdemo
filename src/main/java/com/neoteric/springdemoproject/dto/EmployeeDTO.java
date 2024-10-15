package com.neoteric.springdemoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String employeeId;
    private String name;
    private String dateEmployed;  // Format "yyyy-MM-dd"
    private String jobType;
    private String status;
}
