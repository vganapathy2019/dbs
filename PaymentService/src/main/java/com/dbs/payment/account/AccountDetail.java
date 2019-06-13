package com.dbs.payment.account;

public class AccountDetail {
	private final String email;
	private final String accountNumber;
	private final Double balance;
	
	public AccountDetail(String email, String accountNumber, Double balance) {
		super();
		this.email = email;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "AccountDetail [email=" + email + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}

}
