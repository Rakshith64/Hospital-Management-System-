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

import com.qsp.hospital_management_system.dto.BranchHead;
import com.qsp.hospital_management_system.service.BranchHeadService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class BranchHeadController {
	
	@Autowired
	BranchHeadService branchHeadService;
	
	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}
	
	@GetMapping("/findBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> findBranchHead(@RequestParam int branchHeadId) {
		return branchHeadService.findBranchHead(branchHeadId);
	}
	
	@DeleteMapping("/deleteBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHead(@RequestParam int branchHeadId) {
		return branchHeadService.deleteBranchHead(branchHeadId);
	}
	
	@PutMapping("/updateBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(@RequestParam int oldBranchHeadId,@RequestBody BranchHead newBranchHead) {
		return branchHeadService.updateBranchHead(oldBranchHeadId, newBranchHead);
	}
}
