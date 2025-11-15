package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.PatientDao;
import com.qsp.hospital_management_system.dto.Patient;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class PatientService {
	@Autowired
	PatientDao patientDao;

	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		Patient pat1= patientDao.savePatient(patient);
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>(HttpStatus.CREATED.value(), "Patient created Succesfully", pat1);
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Patient>> findPatientById(int patientId) {
		Patient pat2 = patientDao.findPatientById(patientId);
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>(HttpStatus.FOUND.value(), "Patient fetched Succesfully", pat2);
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(int patientId) {
		Patient pat3= patientDao.deletePatientById(patientId);
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>(HttpStatus.OK.value(), "Patient deleted Succesfully", pat3);
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(int oldPatientId, Patient newPatient) {
		Patient pat4= patientDao.updatePatientById(oldPatientId,newPatient);
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>(HttpStatus.OK.value(), "Patient updated  Succesfully", pat4);
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> addPatientToPrescription(int patientId, int prescriptionId) {
		Patient pat5= patientDao.addPatientToPrescription(patientId, prescriptionId);
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>(HttpStatus.OK.value(), "Patient added to prescription Succesfully", pat5);
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> addPatientToPayment(int patientId, int paymentId) {
		Patient pat6= patientDao.addPatientToPayment(patientId, paymentId);
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>(HttpStatus.OK.value(), "Patient added to payment Succesfully", pat6);
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
	}
}
