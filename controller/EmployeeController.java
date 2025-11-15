package com.qsp.hospital_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management_system.dto.Employee;
import com.qsp.hospital_management_system.service.EmployeeService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/findEmployeeById")
    public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(@RequestParam int empId) {
        return employeeService.findEmployeeById(empId);
    }

    @DeleteMapping("/deleteEmployeeById")
    public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int empId) {
		return employeeService.deleteEmployeeById(empId);
	}

    @PutMapping("/updateEmployeeById")
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(@RequestParam int oldEmpId,@RequestBody Employee newEmployee)
    {
    		return employeeService.updateEmployeeById(oldEmpId, newEmployee);
    }

}
