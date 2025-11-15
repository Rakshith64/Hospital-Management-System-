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

import com.qsp.hospital_management_system.dto.Prescription;
import com.qsp.hospital_management_system.service.PrescriptionService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("/savePrescription")
    public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@RequestBody Prescription prescription) {
        return prescriptionService.savePrescription(prescription);
    }

    @GetMapping("/findPrescriptionById")
    public ResponseEntity<ResponseStructure<Prescription>> findPrescriptionById(@RequestParam int presId) {
        return prescriptionService.findPrescriptionById(presId);
    }

    @DeleteMapping("/deletePrescriptionById")
    public ResponseEntity<ResponseStructure<Prescription>> deletePrescriptionById(@RequestParam int presId) {
		return prescriptionService.deletePrescriptionById(presId);
	}

    @PutMapping("/updatePrescriptionById")
    public ResponseEntity<ResponseStructure<Prescription>> updatePrescriptionById(@RequestParam int oldpresId,@RequestBody Prescription newPrescription)
    {
    		return prescriptionService.updatePrescriptionById(oldpresId, newPrescription);
    }

}
