package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Integer id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Integer id, EmployeeDto updatedEmployeeDto);

    void deleteEmployee(Integer id);

}
