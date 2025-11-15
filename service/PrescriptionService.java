package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.PrescriptionDao;
import com.qsp.hospital_management_system.dto.Prescription;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class PrescriptionService {
	@Autowired
	PrescriptionDao prescriptionDao;

	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(Prescription prescription ) {
		 Prescription pres1 = prescriptionDao.savePrescription(prescription);
		 ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>(HttpStatus.CREATED.value(), " Prescription created Successfully ", pres1);
		 return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Prescription>> findPrescriptionById(int presId) {
		Prescription pres2= prescriptionDao.findPrescriptionById(presId);
		ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>(HttpStatus.FOUND.value(), " Prescription fetched succesfully ", pres2);
		return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure ,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Prescription>> deletePrescriptionById(int presId) {
		Prescription pres3= prescriptionDao.deletePrescriptionById(presId);
		ResponseStructure<Prescription> responseStructure=new ResponseStructure<Prescription>(HttpStatus.OK.value(), " Prescription Deleted Succesfully ", pres3);
		return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure, HttpStatus.OK);
	}


	public ResponseEntity<ResponseStructure<Prescription>> updatePrescriptionById(int oldPresId, Prescription newPrescription) {
		Prescription pres4= prescriptionDao.updatePrescriptionById(oldPresId,newPrescription);
		ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>(HttpStatus.OK.value(), " Prescription updated Succesfully ", pres4);
		return new ResponseEntity<ResponseStructure<Prescription>>(responseStructure,HttpStatus.OK);
	}
}
