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

import com.qsp.hospital_management_system.dto.Owner;
import com.qsp.hospital_management_system.service.OwnerService;
import com.qsp.hospital_management_system.util.ResponseStructure;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping("/saveOwner")
    public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }

    @GetMapping("/findOwnerById")
    public ResponseEntity<ResponseStructure<Owner>> findOwnerById(@RequestParam int OwnerId) {
        return ownerService.findOwnerById(OwnerId);
    }

    @DeleteMapping("/deleteOwnerById")
    public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int OwnerId) {
		return ownerService.deleteOwnerById(OwnerId);
	}

    @PutMapping("/updateOwnerById")
    public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(@RequestParam int oldOwnerID,@RequestBody Owner newOwner) {
    		return ownerService.updateOwnerById(oldOwnerID, newOwner);
    }
    @PutMapping("/addOwnerToHospital/{ownerId}/{hospitalId}")
    public ResponseEntity<ResponseStructure<Owner>> addOwnerToHospital(@PathVariable int ownerId,@PathVariable int hospitalId) {
		return ownerService.addOwnerToHospital(ownerId, hospitalId);
	}

}
