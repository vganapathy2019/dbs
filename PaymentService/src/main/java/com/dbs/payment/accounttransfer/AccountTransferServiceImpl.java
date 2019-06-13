package com.dbs.payment.accounttransfer;

import org.springframework.stereotype.Service;

@Service
public class AccountTransferServiceImpl implements AccountTransferService {
	
	// this is a mock implementation. This would typically be a service class implementing a REST Template
	// and calling the Account Transfer System API. 

	@Override
	public void transfer(String payorAccountNumber, String payeeAccountNumber, Double amount) {
		//	do nothing				
	}

}
