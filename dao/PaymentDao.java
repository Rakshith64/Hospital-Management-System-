package com.qsp.hospital_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospital_management_system.dto.Payment;
import com.qsp.hospital_management_system.exception.DoesNotExistException;
import com.qsp.hospital_management_system.repo.PaymentRepo;

@Repository
public class PaymentDao {
	@Autowired
	PaymentRepo paymentRepo; 

	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}


	public Payment findPaymentById(int paymentId) {
		 Optional<Payment> optional = paymentRepo.findById(paymentId);
		 if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DoesNotExistException("Payment with ID "+paymentId+" does not exist in the database");
		}
	}

	public Payment deletePaymentById(int paymentId) {
		Payment payment = findPaymentById(paymentId);
		paymentRepo.delete(payment);
		return payment;
	}


	public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
		newPayment.setPaymentId(oldPaymentId);
		return paymentRepo.save(newPayment);
	}


}
