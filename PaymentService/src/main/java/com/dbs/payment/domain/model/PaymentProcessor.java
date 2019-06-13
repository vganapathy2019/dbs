package com.dbs.payment.domain.model;


import com.dbs.payment.InsufficientFundsException;
import com.dbs.payment.account.AccountDetail;
import com.dbs.payment.account.AccountService;
import com.dbs.payment.accounttransfer.AccountTransferService;
import com.dbs.payment.notification.NotificationService;

public class PaymentProcessor {

	private AccountService accountService;
	private AccountTransferService accountTransferService;
	private NotificationService notificationService;

	public PaymentProcessor(AccountService accountService, AccountTransferService accountTransferService, NotificationService notificationService) {
		this.accountService = accountService;
		this.accountTransferService = accountTransferService;
		this.notificationService = notificationService;
	}

	public void makePaymentToEmail(String payorAccount, String payeeEmail, Double amount) {
		AccountDetail payeeAccountDetails = accountService.getAccountDetailsByEmail(payeeEmail);
		makePayment(payeeAccountDetails, payorAccount, amount);
		
	}

	public void makePaymentToAccount(String payorAccount, String payeeAccount, Double amount) {
		AccountDetail payeeAccountDetails = accountService.getAccountDetailsByAccountNumber(payeeAccount);
		makePayment(payeeAccountDetails, payorAccount, amount);
	}
	
	private void makePayment(AccountDetail payeeAccountDetails, String payorAccount, Double amount) {
		AccountDetail payorAccountDetails = accountService.getAccountDetailsByAccountNumber(payorAccount);
		
		verifyFunds(payorAccountDetails, amount);
		accountTransferService.transfer(payorAccountDetails.getAccountNumber(), payeeAccountDetails.getAccountNumber(), amount);
		notificationService.notifyAccountOfSuccessfulTransfer(payorAccountDetails.getAccountNumber(), payeeAccountDetails.getAccountNumber(), amount);
		notificationService.notifyAccountOfFundsReceived(payorAccountDetails.getAccountNumber(), payeeAccountDetails.getAccountNumber(), amount);
		
	}

	private void verifyFunds(AccountDetail payorAccountDetails, Double amountToTransfer) {
		if (payorAccountDetails.getBalance().doubleValue() < amountToTransfer.doubleValue()) {
			notificationService.notifyAccountOfInsufficientFunds(payorAccountDetails.getAccountNumber(), amountToTransfer, payorAccountDetails.getBalance());
			throw new InsufficientFundsException("Not enough funds. Current Balance: " + payorAccountDetails.getBalance() + 
					" Transfer Requested For Amount: " + amountToTransfer);
		}
	}


}
