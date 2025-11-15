package com.qsp.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Ambulance;
import com.qsp.hospital_management_system.dto.Branch;
import com.qsp.hospital_management_system.dto.BranchHead;
import com.qsp.hospital_management_system.dto.Doctor;
import com.qsp.hospital_management_system.dto.Employee;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.BranchRepo;

import jakarta.transaction.Transactional;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	BranchHeadDao branchHeadDao;
	@Autowired
	AmbulanceDao ambulanceDao;
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	EmployeeDao employeeDao;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch findBranchById(int branchId) {
		  Optional<Branch> optional = branchRepo.findById(branchId);
		  if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Branch with BranchID "+branchId+ " does not exist in the database");
		}
	}

	@Transactional
	public Branch deleteBranch(int branchId) {
		Branch branch = findBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	
	public Branch updateBranch(int oldBranchId,Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}
	
	public Branch addBranchToBranchHead(int branchId,int branchHeadId) {
		Branch branch=findBranchById(branchId);
		BranchHead branchHead=branchHeadDao.findBranchHead(branchHeadId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}
	
	public Branch addBranchToAmbulance(int branchId, int ambulanceId) {
		Branch branch = findBranchById(branchId);
		Ambulance ambulance = ambulanceDao.findAmbulanceById(ambulanceId);
		List<Ambulance> list = branch.getAmbulance();
		list.add(ambulance);
		return saveBranch(branch);
	}
	
	public Branch addBranchToDoctor(int branchId , int doctorId) {
		Branch branch = findBranchById(branchId);
		Doctor doctor = doctorDao.findDoctor(doctorId);
		List<Doctor> list = branch.getDoctor();
		list.add(doctor);
		return saveBranch(branch);
	}
	
	public Branch addBranchToEmployee(int branchId,int employeeId) {
		Branch branch = findBranchById(branchId);
		Employee employee = employeeDao.findEmployeeById(employeeId);
		List<Employee> list = branch.getEmployee();
		list.add(employee);
		return saveBranch(branch);
	}
}
