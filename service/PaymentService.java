package com.qsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.hospital_management_system.dao.PaymentDao;
import com.qsp.hospital_management_system.dto.Payment;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;

	public Payment savePayment(Payment payment ) {
		return paymentDao.savePayment(payment);
	}

	public Payment findPaymentById(int paymentId) {
		return paymentDao.findPaymentById(paymentId);
	}

	public Payment deletePaymentById(int paymentId) {
		return paymentDao.deletePaymentById(paymentId);
	}


	public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
		return paymentDao.updatePaymentById(oldPaymentId,newPayment);
	}
}
