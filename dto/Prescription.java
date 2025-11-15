package com.qsp.hospital_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int presId;
	private String presDate;
	private String presGivenBy;
	public int getPresId() {
		return presId;
	}
	public void setPresId(int presId) {
		this.presId = presId;
	}
	public String getPresDate() {
		return presDate;
	}
	public void setPresDate(String presDate) {
		this.presDate = presDate;
	}
	public String getPresGivenBy() {
		return presGivenBy;
	}
	public void setPresGivenBy(String presGivenBy) {
		this.presGivenBy = presGivenBy;
	}
	
	
}
