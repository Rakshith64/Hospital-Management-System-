package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.OwnerDao;
import com.qsp.hospital_management_system.dto.Owner;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		 Owner own1 = ownerDao.saveOwner(owner);
		  ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>(HttpStatus.CREATED.value(), "Owner saved Succesfully", own1);
		  return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> findOwnerById(int OwnerId) {
		 Owner own2 = ownerDao.findOwnerById(OwnerId);
		 ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>(HttpStatus.FOUND.value(), "Owner data fetched sucessfully", own2);
		 return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int OwnerId) {
		 Owner own3 = ownerDao.deleteOwnerById(OwnerId);
		 ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>(HttpStatus.OK.value(), "Owner data deleted sucessfully", own3);
		 return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
	}


	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerID, Owner newOwner) {
		Owner own4 = ownerDao.updateOwnerById(oldOwnerID,newOwner);
		ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>(HttpStatus.OK.value(), "Owner data updated sucessfully", own4);
		 return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Owner>> addOwnerToHospital(int ownerId, int hospitalId) {
		Owner own5= ownerDao.addOwnerToHospital(ownerId, hospitalId);
		ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>(HttpStatus.OK.value(), "Owner data fetched sucessfully", own5);
		 return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
	}
}
