package com.qsp.hospital_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management_system.dto.Ambulance;
import com.qsp.hospital_management_system.service.AmbulanceService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class AmbulanceController {
	@Autowired
	AmbulanceService ambulanceService;

	@PostMapping("/saveAmbulance")
	public ResponseEntity<ResponseStructure<Ambulance>> saveAmbulance(@RequestBody Ambulance ambulance) {
		return ambulanceService.saveAmbulance(ambulance);
	}

	@GetMapping("/findAmbulanceById")
	    public ResponseEntity<ResponseStructure<Ambulance>> findAmbulanceById(@RequestParam int ambId) {
			return ambulanceService.findAmbulanceById(ambId);
	}

	 @DeleteMapping("/deleteAmbulanceById")
	    public ResponseEntity<ResponseStructure<Ambulance>> deleteAmbulanceById(@RequestParam int ambId) {
			return ambulanceService.deleteAmbulanceById(ambId);
		}
	 @PutMapping("/updateAmbulanceById")
	    public ResponseEntity<ResponseStructure<Ambulance>> updateAmbulanceById(@RequestParam int oldAmbId,@RequestBody Ambulance newAmbulance)
	    {
	    		return ambulanceService.updateAmbulanceById(oldAmbId, newAmbulance);
	    }

}
