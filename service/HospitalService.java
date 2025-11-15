package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.HospitalDao;
import com.qsp.hospital_management_system.dto.Hospital;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	HospitalDao hospitalDao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		 Hospital hos1 = hospitalDao.saveHospital(hospital);
		 ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>(HttpStatus.CREATED.value(), "Hospital Saved Succesfully", hos1);
		 return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int hospitalId) {
		Hospital hos2= hospitalDao.findHospitalById(hospitalId);
		 ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>(HttpStatus.FOUND.value(), "Hospital fetched Succesfully", hos2);
		 return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int hospitalId) {
		Hospital hos3= hospitalDao.deleteHospitalById(hospitalId);
		 ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>(HttpStatus.OK.value(), "Hospital Deleted Succesfully", hos3);
		 return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}


	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(int oldHospitalID, Hospital newHospital) {
		Hospital hos4 = hospitalDao.updateHospitalById(oldHospitalID,newHospital);
		 ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>(HttpStatus.OK.value(), "Hospital Updated Succesfully", hos4);
		 return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Hospital>> addHospitalToBranch(int hospitalId,int branchId) {
		Hospital hos5= hospitalDao.addHospitalToBranch(hospitalId, branchId);
		 ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>(HttpStatus.OK.value(), "Hospital added to branch Succesfully", hos5);
		 return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
	}
}
