package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.EmployeeDao;
import com.qsp.hospital_management_system.dto.Employee;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee ) {
		 Employee emp1 = employeeDao.saveEmployee(employee);
		 ResponseStructure<Employee> responseStructure= new ResponseStructure<Employee>(HttpStatus.CREATED.value(), "Employee created succesfully", emp1);
		 return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(int empId) {
		 Employee emp2 = employeeDao.findEmployeeById(empId);
		 ResponseStructure<Employee> responseStructure= new ResponseStructure<Employee>(HttpStatus.FOUND.value(), "Employee fetched succesfully", emp2);
		 return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int empId) {
		 Employee emp3 = employeeDao.deleteEmployeeById(empId);
		 ResponseStructure<Employee> responseStructure= new ResponseStructure<Employee>(HttpStatus.OK.value(), "Employee deleted succesfully", emp3);
		 return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
	}


	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int oldEmpId, Employee newEmployee) {
		 Employee emp4 = employeeDao.updateEmployeeById(oldEmpId,newEmployee);
		 ResponseStructure<Employee> responseStructure= new ResponseStructure<Employee>(HttpStatus.OK.value(), "Employee updated succesfully", emp4);
		 return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
	}
}
