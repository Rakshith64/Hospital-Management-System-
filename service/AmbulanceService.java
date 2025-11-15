package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.AmbulanceDao;
import com.qsp.hospital_management_system.dto.Ambulance;
import com.qsp.hospital_management_system.util.ResponseStructure;

@Service
public class AmbulanceService {
	@Autowired
	AmbulanceDao ambulanceDao;

	public ResponseEntity<ResponseStructure<Ambulance>> saveAmbulance(Ambulance ambulance) {
		Ambulance amb1= ambulanceDao.saveAmbulance(ambulance);
		ResponseStructure<Ambulance> responseStructure=new ResponseStructure<Ambulance>(HttpStatus.CREATED.value(), "Ambulance Created Succesfully", amb1);
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure,HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<Ambulance>> findAmbulanceById(int ambId) {
		Ambulance amb2= ambulanceDao.findAmbulanceById(ambId);
		ResponseStructure<Ambulance> responseStructure=new ResponseStructure<Ambulance>(HttpStatus.CREATED.value(), "Ambulance Fetched Succesfully", amb2);
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Ambulance>> deleteAmbulanceById(int ambId) {
		Ambulance amb3= ambulanceDao.deleteAmbulanceById(ambId);
		ResponseStructure<Ambulance> responseStructure=new ResponseStructure<Ambulance>(HttpStatus.OK.value(), "Ambulance Deleted Succesfully", amb3);
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure,HttpStatus.OK);
	}


	public ResponseEntity<ResponseStructure<Ambulance>> updateAmbulanceById(int oldAmbId, Ambulance newAmbulance) {
		Ambulance amb4= ambulanceDao.updateAmbulanceById(oldAmbId,newAmbulance);
		ResponseStructure<Ambulance> responseStructure=new ResponseStructure<Ambulance>(HttpStatus.OK.value(), "Ambulance Updated Succesfully", amb4);
		return new ResponseEntity<ResponseStructure<Ambulance>>(responseStructure,HttpStatus.OK);
	}

}
