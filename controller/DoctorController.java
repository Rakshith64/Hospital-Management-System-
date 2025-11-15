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

import com.qsp.hospital_management_system.dto.Doctor;
import com.qsp.hospital_management_system.service.DoctorService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/saveDoctor")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
	
	@GetMapping("/findDoctor")
	public ResponseEntity<ResponseStructure<Doctor>> findDoctor(@RequestParam int doctorId) {
		return doctorService.findDoctor(doctorId);
	}
	
	@DeleteMapping("/deleteDoctor")
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctor(@RequestParam int doctorId) {
		return doctorService.deleteDoctor(doctorId);
	}
	
	@PutMapping("/updateDoctor")
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@RequestParam int oldDoctorId,@RequestBody Doctor newDoctor) {
		return doctorService.updateDoctor(oldDoctorId, newDoctor);
	}
	
	@PutMapping("/addDoctorToPatient/{doctorId}/{patientId}")
	public ResponseEntity<ResponseStructure<Doctor>> addDoctorToPatient(@PathVariable int doctorId,@PathVariable int patientId) {
		return doctorService.addDoctorToPatient(doctorId, patientId);
	}
}
