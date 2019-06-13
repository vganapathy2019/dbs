package com.dbs.payment.notification;

public interface NotificationService {
	void notifyAccountOfInsufficientFunds(String payerAccountNumber, Double transferAmount, Double accountBalance);
	void notifyAccountOfSuccessfulTransfer(String payerAccountNumber, String payeeAccountNumber, Double transferAmount);
	void notifyAccountOfFundsReceived(String payerAccountNumber, String payeeAccountNumber, Double transferAmount);

}
