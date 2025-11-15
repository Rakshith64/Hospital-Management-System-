package com.qsp.hospital_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Employee;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo; 

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}


	public Employee findEmployeeById(int empId) {
		 Optional<Employee> optional = employeeRepo.findById(empId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Employee with ID "+empId+" does not exist in the database");
		}
	}

	public Employee deleteEmployeeById(int empId) {
		Employee employee = findEmployeeById(empId);
		employeeRepo.delete(employee);
		return employee;
	}


	public Employee updateEmployeeById(int oldEmpId, Employee newEmployee) {
		newEmployee.setEmpId(oldEmpId);
		return employeeRepo.save(newEmployee);
	}


}
