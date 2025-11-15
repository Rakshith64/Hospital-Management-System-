package com.qsp.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Branch;
import com.qsp.hospital_management_system.dto.Hospital;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	HospitalRepo hospitalRepo;
	
	@Autowired
	BranchDao branchDao;
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);

	}

	public Hospital findHospitalById(int hospitalId) {
		 Optional<Hospital> optional = hospitalRepo.findById(hospitalId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Hospital with ID "+hospitalId+" does not exist in the database");
		}
	}

	public Hospital deleteHospitalById(int HospitalId) {
		Hospital hospital = findHospitalById(HospitalId);
		hospitalRepo.delete(hospital);
		return hospital;
	}

	public Hospital updateHospitalById(int oldHospitalID, Hospital newHospital) {
		newHospital.setHospitalId(oldHospitalID);
		return hospitalRepo.save(newHospital);
	}
	
	public Hospital addHospitalToBranch(int hospitalId,int branchId) {
		Hospital hospital=findHospitalById(hospitalId);
		Branch branch = branchDao.findBranchById(branchId);
		List<Branch> list = hospital.getBranch();
		list.add(branch);
		return saveHospital(hospital);
	}
}
