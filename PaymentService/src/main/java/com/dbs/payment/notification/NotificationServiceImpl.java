package com.dbs.payment.notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	// this is a mock implementation. This would typically be a service class implementing a REST Template
	// and calling the Notification System API. 

	@Override
	public void notifyAccountOfInsufficientFunds(String payerAccountNumber, Double transferAmount,
			Double accountBalance) {
		// 

	}

	@Override
	public void notifyAccountOfSuccessfulTransfer(String payerAccountNumber, String payeeAccountNumber,
			Double transferAmount) {
		// 

	}

	@Override
	public void notifyAccountOfFundsReceived(String payerAccountNumber, String payeeAccountNumber,
			Double transferAmount) {
		// 

	}

}
