package com.dbs.payment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.payment.account.AccountService;
import com.dbs.payment.accounttransfer.AccountTransferService;
import com.dbs.payment.domain.model.PaymentProcessor;
import com.dbs.payment.notification.NotificationService;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountTransferService accountTransferService;
	
	@Autowired
	private NotificationService notificationService;

	@Override
	public void paymentToEmail(String payorAccount, String payeeEmail, Double amount) {
		PaymentProcessor processor = new PaymentProcessor(accountService, accountTransferService, notificationService);
		processor.makePaymentToEmail(payorAccount, payeeEmail, amount);
	}

	@Override
	public void paymentToAccount(String payorAccount, String payeeAccount, Double amount) {
		PaymentProcessor processor = new PaymentProcessor(accountService, accountTransferService, notificationService);
		processor.makePaymentToAccount(payorAccount, payeeAccount, amount);
	}

}
