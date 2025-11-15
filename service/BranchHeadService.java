package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.BranchHeadDao;
import com.qsp.hospital_management_system.dto.BranchHead;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class BranchHeadService {
	@Autowired
	BranchHeadDao branchHeadDao;
	
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
		BranchHead branHead1= branchHeadDao.saveBranchHead(branchHead);
		ResponseStructure<BranchHead> responseStructure= new ResponseStructure<BranchHead>(HttpStatus.CREATED.value(), "Branch Head Created Succesfully", branHead1);
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> findBranchHead(int branchId) {
		BranchHead branHead2= branchHeadDao.findBranchHead(branchId);
		ResponseStructure<BranchHead> responseStructure= new ResponseStructure<BranchHead>(HttpStatus.FOUND.value(), "Branch Head Fetched Succesfully", branHead2);
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHead(int branchId) {
		BranchHead branHead3= branchHeadDao.deleteBranchHead(branchId);
		ResponseStructure<BranchHead> responseStructure= new ResponseStructure<BranchHead>(HttpStatus.OK.value(), "Branch Head Deleted Succesfully", branHead3);
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHead(int oldBranchHeadId, BranchHead newBranchHead) {
		BranchHead branHead4= branchHeadDao.updateBranchHead(oldBranchHeadId, newBranchHead);
		ResponseStructure<BranchHead> responseStructure= new ResponseStructure<BranchHead>(HttpStatus.OK.value(), "Branch Head Updated Succesfully", branHead4);
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
	}
}
