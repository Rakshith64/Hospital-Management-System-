package com.qsp.hospital_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospital_management_system.dto.Hospital;
import com.qsp.hospital_management_system.service.HospitalService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;

	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	@GetMapping("/findHospitalById")
	    public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(@RequestParam int hospitalId) {
			return hospitalService.findHospitalById(hospitalId);
	}

	 @DeleteMapping("/deleteHospitalById")
	    public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@RequestParam int HospitalId) {
			return hospitalService.deleteHospitalById(HospitalId);
		}
	 @PutMapping("/updateHospitalById")
	    public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@RequestParam int oldHospitalID,@RequestBody Hospital newHospital)
	    {
	    		return hospitalService.updateHospitalById(oldHospitalID, newHospital);
	    }
	 @PutMapping("/addHospitalToBranch/{hospitalId}/{branchId}")
	 public ResponseEntity<ResponseStructure<Hospital>> addHospitalToBranch(@PathVariable int hospitalId,@PathVariable int branchId) {
			return hospitalService.addHospitalToBranch(hospitalId, branchId);
		}
}
