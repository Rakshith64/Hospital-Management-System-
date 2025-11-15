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

import com.qsp.hospital_management_system.dto.Patient;
import com.qsp.hospital_management_system.service.PatientService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/savePatient")
    public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }
    
    @GetMapping("/findPatientById")
    public ResponseEntity<ResponseStructure<Patient>> findPatientById(@RequestParam int patientId) {
        return patientService.findPatientById(patientId);
    }
    
    @DeleteMapping("/deletePatientById")
    public ResponseEntity<ResponseStructure<Patient>> deletePatientById(@RequestParam int patientId) {
		return patientService.deletePatientById(patientId);
	}
    
    @PutMapping("/updatePatientById")
    public ResponseEntity<ResponseStructure<Patient>> updatePatientById(@RequestParam int oldPatientId,@RequestBody Patient newPatient) {
    		return patientService.updatePatientById(oldPatientId, newPatient);
    }
    
    @PutMapping("/addPatientToPrescription/{patientId}/{prescriptionId}")
    public ResponseEntity<ResponseStructure<Patient>> addPatientToPrescription(@PathVariable int patientId,@PathVariable int prescriptionId) {
    		return patientService.addPatientToPrescription(patientId, prescriptionId);
    }
    
    @PutMapping("/addPatientToPayment/{patientId}/{paymentId}")
    public ResponseEntity<ResponseStructure<Patient>> addPatientToPayment(@PathVariable int patientId,@PathVariable int paymentId) {
    		return patientService.addPatientToPayment(patientId, paymentId);
    }
    
}
