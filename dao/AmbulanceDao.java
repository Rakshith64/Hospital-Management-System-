package com.qsp.hospital_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Ambulance;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.AmbulanceRepo;

@Repository
public class AmbulanceDao {
	@Autowired
	AmbulanceRepo ambulanceRepo ;

	public Ambulance saveAmbulance(Ambulance ambulance) {
		return ambulanceRepo.save(ambulance);

	}


	public Ambulance findAmbulanceById(int ambId) {
		 Optional<Ambulance> optional = ambulanceRepo.findById(ambId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw  new DoesNotExistException("Ambulance with ID "+ ambId + "does not exist in Database");
		}
	}

	public Ambulance deleteAmbulanceById(int ambId) {
		Ambulance ambulance = findAmbulanceById(ambId);
		ambulanceRepo.delete(ambulance);
		return ambulance;
	}

	public Ambulance updateAmbulanceById(int oldAmbId, Ambulance newAmbulance) {
		newAmbulance.setAmbId(oldAmbId);
		return ambulanceRepo.save(newAmbulance);
	}
}
