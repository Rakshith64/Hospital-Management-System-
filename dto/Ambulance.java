package com.qsp.hospital_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ambulance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ambId;
	private String ambRegNo;
	private String ambType;
	
	
	public int getAmbId() {
		return ambId;
	}
	public void setAmbId(int ambId) {
		this.ambId = ambId;
	}
	public String getAmbRegNo() {
		return ambRegNo;
	}
	public void setAmbRegNo(String ambRegNo) {
		this.ambRegNo = ambRegNo;
	}
	public String getAmbType() {
		return ambType;
	}
	public void setAmbType(String ambType) {
		this.ambType = ambType;
	}
	
	
}
