package com.dbs.payment.account;

public interface AccountService {
	AccountDetail getAccountDetailsByEmail(String email);
	AccountDetail getAccountDetailsByAccountNumber(String accountNumber);

}
