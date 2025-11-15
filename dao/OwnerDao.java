package com.qsp.hospital_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Hospital;
import com.qsp.hospital_management_system.dto.Owner;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;
	@Autowired
	HospitalDao hospitalDao;
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}


	public Owner findOwnerById(int OwnerId) {
		Optional<Owner> optional= ownerRepo.findById(OwnerId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Owner with ID "+ OwnerId + "does not exist");
		}
	}

	public Owner deleteOwnerById(int OwnerId) {
		Owner owner = findOwnerById(OwnerId);
		ownerRepo.delete(owner);
		return owner;
	}

	public Owner updateOwnerById(int oldOwnerID, Owner newOwner) {
		newOwner.setOwnerId(oldOwnerID);
		return ownerRepo.save(newOwner);
	}
	public Owner addOwnerToHospital(int ownerId, int hospitalId) {
		Owner owner=findOwnerById(ownerId);
		Hospital hospital=hospitalDao.findHospitalById(hospitalId);
		owner.setHospital(hospital);
		return saveOwner(owner);
	}

}
