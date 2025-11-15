package com.qsp.hospital_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management_system.dto.Branch;
import com.qsp.hospital_management_system.service.BranchService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;

	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	
	@GetMapping("/findBranch")
	public ResponseEntity<ResponseStructure<Branch>> findBranchById(@RequestParam int branchId) {
		return branchService.findBranchById(branchId);
	}
	
	
	@DeleteMapping("/deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int branchId) {
		return branchService.deleteBranch(branchId);
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int oldBranchId,@RequestBody Branch newBranch) {
		return branchService.updateBranch(oldBranchId, newBranch);
	}
	
	@PutMapping("/addBranchToBranchHead/{branchId}/{branchHeadId}")
	public ResponseEntity<ResponseStructure<Branch>> addBranchToBranchHead(@PathVariable int branchId,@PathVariable int branchHeadId) {
		return branchService.addBranchToBranchHead(branchId, branchHeadId);
	}
	
	@PutMapping("/addBranchToAmbulance/{branchId}/{ambulanceId}")
	public ResponseEntity<ResponseStructure<Branch>> addAmbulanceToBranchHead(@PathVariable int branchId,@PathVariable int ambulanceId) {
		return branchService.addBranchToAmbulance(branchId, ambulanceId);
	}
	
	@PutMapping("/addBranchToDoctor/{branchId}/{doctorId}")
	public ResponseEntity<ResponseStructure<Branch>> addBranchToDoctor(@PathVariable int branchId ,@PathVariable int doctorId) {
		return branchService.addBranchToDoctor(branchId, doctorId);
	}
	@PutMapping("/addBranchToEmployee/{branchId}/{employeeId}")
	public ResponseEntity<ResponseStructure<Branch>> addBranchToEmployee(@PathVariable int branchId,@PathVariable int employeeId) {
		return branchService.addBranchToEmployee(branchId, employeeId);
	}
}
