package com.dbs.payment.account;

import org.springframework.stereotype.Service;

import com.dbs.payment.AccountNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {
	
	// this is a mock implementation. This would typically be a service class implementing a REST Template
	// and calling the Account Service System API. The results returned by the API would be converted to a AccountDetail object 
	// and returned
	

	@Override
	public AccountDetail getAccountDetailsByEmail(String email) {
		if (email.equalsIgnoreCase("vijay@gmail.com")) {
			return new AccountDetail(email, "1234543216", 8345.10);
		}
		
		// to test account not found case
		throw new AccountNotFoundException("Account Not Found for email: " + email);
	}

	@Override
	public AccountDetail getAccountDetailsByAccountNumber(String accountNumber) {
		
		if (accountNumber.equals("123456789") || accountNumber.equals("111111111")) {
			return new AccountDetail("vijay@gmail.com", accountNumber, 1000.10);
		}
		// to test account not found case
		throw new AccountNotFoundException("Account Not Found for accountNumber: " + accountNumber);
	}

}
