package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.Mapper.EmployeeMapper;
import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Implement the methods from the EmployeeService interface
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    // Implement the methods from the EmployeeService interface
    @Override
    public EmployeeDto getEmployeeById(Integer id){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Employee not found" + id));
        return EmployeeMapper.toEmployeeDto(employee);
    }

    // Implement the methods from the EmployeeService interface
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
    }

    // Implement the methods from the EmployeeService interface
    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Employee not found" + id));
        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(updatedEmployee);
    }

    //
    @Override
    public void deleteEmployee(Integer id) {
       employeeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Employee not found" + id));
        employeeRepository.deleteById(id);
    }
}
