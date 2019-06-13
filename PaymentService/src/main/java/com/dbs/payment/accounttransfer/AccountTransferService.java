package com.dbs.payment.accounttransfer;

public interface AccountTransferService {
	void transfer(String payorAccountNumber, String payeeAccountNumber, Double amount);

}
