package com.qsp.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Patient;
import com.qsp.hospital_management_system.dto.Payment;
import com.qsp.hospital_management_system.dto.Prescription;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.PatientRepo;

@Repository
public class PatientDao {
	@Autowired
	PatientRepo patientRepo;
	@Autowired
	PrescriptionDao prescriptionDao;
	@Autowired
	PaymentDao paymentDao;

	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	public Patient findPatientById(int patientId) {
		 Optional<Patient> optional = patientRepo.findById(patientId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Patient with ID "+patientId+" does not exist in the database");
		}
	}

	public Patient deletePatientById(int patientId) {
		Patient patient = findPatientById(patientId);
		patientRepo.delete(patient);
		return patient;
	}

	public Patient updatePatientById(int oldPatientId, Patient newPatient) {
		newPatient.setPatientId(oldPatientId);
		return patientRepo.save(newPatient);
	}

	public Patient addPatientToPrescription(int patientId, int prescriptionId) {
		Patient patient = findPatientById(patientId);
		Prescription prescription = prescriptionDao.findPrescriptionById(prescriptionId);
		List<Prescription> list = patient.getPrescription();
		list.add(prescription);
		return savePatient(patient);
	}
	
	public Patient addPatientToPayment(int patientId, int paymentId) {
		Patient patient= findPatientById(patientId);
		Payment payment= paymentDao.findPaymentById(paymentId);
		List<Payment> list = patient.getPayment();
		list.add(payment);
		return savePatient(patient);
	}

}
