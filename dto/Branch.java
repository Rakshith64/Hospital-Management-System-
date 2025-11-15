package com.qsp.hospital_management_system.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private long branchPhNumber;
	private String branchGST;
	
	@OneToOne
	private BranchHead branchHead;
	@OneToMany
	private List<Ambulance>  ambulance;
	@OneToMany
	private List<Doctor> doctor;
	@OneToMany
	private List<Employee> employee;
	
	
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	public List<Ambulance> getAmbulance() {
		return ambulance;
	}

	public void setAmbulance(List<Ambulance> ambulance) {
		this.ambulance = ambulance;
	}

	public BranchHead getBranchHead() {
		return branchHead;
	}

	public void setBranchHead(BranchHead branchHead) {
		this.branchHead = branchHead;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getBranchPhNumber() {
		return branchPhNumber;
	}

	public void setBranchPhNumber(long branchPhNumber) {
		this.branchPhNumber = branchPhNumber;
	}

	public String getBranchGST() {
		return branchGST;
	}

	public void setBranchGST(String branchGST) {
		this.branchGST = branchGST;
	}

}
