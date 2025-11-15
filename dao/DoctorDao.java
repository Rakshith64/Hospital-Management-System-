package com.qsp.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Doctor;
import com.qsp.hospital_management_system.dto.Patient;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.DoctorRepo;

@Repository
public class DoctorDao {
	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	PatientDao patientDao;
	
	
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	public Doctor findDoctor(int doctorId) {
		 Optional<Doctor> optional = doctorRepo.findById(doctorId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Doctor with ID "+doctorId+" does not exist in the database");
		}
	}
	
	public Doctor deleteDoctor(int doctorId) {
		Doctor doctor = findDoctor(doctorId);
		doctorRepo.deleteById(doctorId);
		return doctor;
	}
	
	public Doctor updateDoctor(int oldDoctorId, Doctor newDoctor) {
		newDoctor.setDoctorId(oldDoctorId);
		return doctorRepo.save(newDoctor);
	}
	public Doctor addDoctorToPatient(int doctorId, int patientId) {
		Doctor doctor= findDoctor(doctorId);
		Patient patient = patientDao.findPatientById(patientId);
		List<Patient> list = doctor.getPatient();
		list.add(patient);
		return saveDoctor(doctor);
	}
	
}
