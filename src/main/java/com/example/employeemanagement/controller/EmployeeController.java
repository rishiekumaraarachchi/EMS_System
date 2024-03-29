package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Implement the methods from the EmployeeService interface
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
       EmployeeDto savedEmployee = employeeService.addEmployee(employeeDto);
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Implement the methods from the EmployeeService interface
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Integer id){
        EmployeeDto getEmployee = employeeService.getEmployeeById(id);
                return ResponseEntity.ok(getEmployee);
    }

    // Implement the methods from the EmployeeService interface
    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        List<EmployeeDto> employeeDto = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDto);
    }

    // Implement the methods from the EmployeeService interface
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeDto updatedEmployeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, updatedEmployeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Implement the methods from the EmployeeService interface
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee with ID " + id + " has been deleted successfully.");
    }
}
