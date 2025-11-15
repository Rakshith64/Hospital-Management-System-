package com.qsp.hospital_management_system.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientDisease;
	private String patientName;
	private long patientPhNo;
	@OneToMany
	private List<Prescription> prescription;
	@OneToMany
	private List<Payment> payment;
	
	
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public List<Prescription> getPrescription() {
		return prescription;
	}
	public void setPrescription(List<Prescription> prescription) {
		this.prescription = prescription;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientDisease() {
		return patientDisease;
	}
	public void setPatientDisease(String patientDisease) {
		this.patientDisease = patientDisease;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public long getPatientPhNo() {
		return patientPhNo;
	}
	public void setPatientPhNo(long patientPhNo) {
		this.patientPhNo = patientPhNo;
	}
	
	
}
