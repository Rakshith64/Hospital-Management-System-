package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.BranchDao;
import com.qsp.hospital_management_system.dto.Branch;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		Branch bran1= branchDao.saveBranch(branch);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.CREATED.value(), "Branch saved Succesfully", bran1);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> findBranchById(int branchId) {
		Branch bran2 = branchDao.findBranchById(branchId);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.FOUND.value(), "Branch fetched Succesfully", bran2);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int branchId) {
		Branch bran3= branchDao.deleteBranch(branchId);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.OK.value(), "Branch deleted Succesfully", bran3);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int oldBranchId, Branch newBranch) {
		Branch bran4= branchDao.updateBranch(oldBranchId, newBranch);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.OK.value(), "Branch updated Succesfully", bran4);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addBranchToBranchHead(int branchId,int branchHeadId) {
		Branch bran5= branchDao.addBranchToBranchHead(branchId, branchHeadId);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.OK.value(), "Branch added to Branch Head Succesfully", bran5);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addBranchToAmbulance(int branchId, int ambulanceId) {
		Branch bran6= branchDao.addBranchToAmbulance(branchId, ambulanceId);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.OK.value(), "Branch added to Ambulances Succesfully", bran6);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addBranchToDoctor(int branchId , int doctorId) {
		Branch bran7= branchDao.addBranchToDoctor(branchId, doctorId);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.OK.value(), "Branch added to Doctor Succesfully", bran7);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addBranchToEmployee(int branchId,int employeeId) {
		Branch bran8= branchDao.addBranchToEmployee(branchId, employeeId);
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>(HttpStatus.OK.value(), "Branch added to Employee Succesfully", bran8);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
}
