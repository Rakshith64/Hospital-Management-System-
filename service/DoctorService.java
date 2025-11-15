package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.DoctorDao;
import com.qsp.hospital_management_system.dto.Doctor;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class DoctorService {
	@Autowired
	DoctorDao doctorDao;
	
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor) {
		Doctor doc1= doctorDao.saveDoctor(doctor);
		ResponseStructure<Doctor> responseStructure= new ResponseStructure<Doctor>(HttpStatus.CREATED.value(), "Doctor created succesfully", doc1);
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> findDoctor(int doctorId) {
		Doctor doc2= doctorDao.findDoctor(doctorId);
		ResponseStructure<Doctor> responseStructure= new ResponseStructure<Doctor>(HttpStatus.CREATED.value(), "Doctor fetched succesfully", doc2);
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctor(int doctorId) {
		Doctor doc3= doctorDao.deleteDoctor(doctorId);
		ResponseStructure<Doctor> responseStructure= new ResponseStructure<Doctor>(HttpStatus.CREATED.value(), "Doctor deleted succesfully", doc3);
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(int oldDoctorId, Doctor newDoctor) {
		Doctor doc4= doctorDao.updateDoctor(oldDoctorId, newDoctor);
		ResponseStructure<Doctor> responseStructure= new ResponseStructure<Doctor>(HttpStatus.CREATED.value(), "Doctor updated succesfully", doc4);
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Doctor>> addDoctorToPatient(int doctorId, int patientId) {
		Doctor doc5= doctorDao.addDoctorToPatient(doctorId, patientId);
		ResponseStructure<Doctor> responseStructure= new ResponseStructure<Doctor>(HttpStatus.CREATED.value(), "Doctor added to patient succesfully", doc5);
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.CREATED);
	}
}
