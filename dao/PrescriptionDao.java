package com.qsp.hospital_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Prescription;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.PrescriptionRepo;

@Repository
public class PrescriptionDao {
	@Autowired
	PrescriptionRepo prescriptionRepo; 

	public Prescription savePrescription(Prescription prescription) {
		return prescriptionRepo.save(prescription);
	}


	public Prescription findPrescriptionById(int presId) {
		 Optional<Prescription> optional = prescriptionRepo.findById(presId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Prescription with ID "+presId+" does not exist in the database");
		}
	}

	public Prescription deletePrescriptionById(int presId) {
		Prescription prescription = findPrescriptionById(presId);
		prescriptionRepo.delete(prescription);
		return prescription;
	}


	public Prescription updatePrescriptionById(int oldPresId, Prescription newPrescription) {
		newPrescription.setPresId(oldPresId);
		return prescriptionRepo.save(newPrescription);
	}


}
