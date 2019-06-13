package com.dbs.payment.application.service;

public interface PaymentService {
	void paymentToEmail(String payorAccount, String payeeEmail, Double amount);
	void paymentToAccount(String payorAccount, String payeeAccount, Double amount);

}
