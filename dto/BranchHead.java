package com.qsp.hospital_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BranchHead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchHeadId;
	private String branchHeadName;
	private long branchHeadPhno;
	private String branchHeadEmail;
	public int getBranchHeadId() {
		return branchHeadId;
	}
	public void setBranchHeadId(int branchHeadId) {
		this.branchHeadId = branchHeadId;
	}
	public String getBranchHeadName() {
		return branchHeadName;
	}
	public void setBranchHeadName(String branchHeadName) {
		this.branchHeadName = branchHeadName;
	}
	public long getBranchHeadPhno() {
		return branchHeadPhno;
	}
	public void setBranchHeadPhno(long branchHeadPhno) {
		this.branchHeadPhno = branchHeadPhno;
	}
	public String getBranchHeadEmail() {
		return branchHeadEmail;
	}
	public void setBranchHeadEmail(String branchHeadEmail) {
		this.branchHeadEmail = branchHeadEmail;
	}
	
	
}
