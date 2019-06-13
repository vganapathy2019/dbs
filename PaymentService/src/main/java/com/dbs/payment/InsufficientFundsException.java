package com.dbs.payment;

public class InsufficientFundsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficientFundsException(String details) {
		super(details);
	}

}
