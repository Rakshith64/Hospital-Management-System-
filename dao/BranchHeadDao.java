package com.qsp.hospital_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.BranchHead;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.BranchHeadRepo;

@Repository
public class BranchHeadDao {
	@Autowired
	BranchHeadRepo branchHeadRepo;
	
	public BranchHead saveBranchHead(BranchHead branchHead) {
		return branchHeadRepo.save(branchHead);
	}
	
	public BranchHead  findBranchHead(int branchHeadId) {
		 Optional<BranchHead> optional = branchHeadRepo.findById(branchHeadId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Branch Head with ID "+branchHeadId+" does not exist in the database");
		}
	}
	
	public BranchHead deleteBranchHead(int branchHeadId) {
		BranchHead branchHead = findBranchHead(branchHeadId);
		branchHeadRepo.delete(branchHead);
		return branchHead;
	}
	
	public BranchHead updateBranchHead(int oldBranchHeadId, BranchHead newBranchHead) {
		newBranchHead.setBranchHeadId(oldBranchHeadId);
		return branchHeadRepo.save(newBranchHead);
	}
}
