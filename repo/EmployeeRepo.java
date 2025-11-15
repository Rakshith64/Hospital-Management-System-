package com.qsp.hospital_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospital_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
