package com.dbs.payment.controller.dto;

public class AccountPaymentDto {
	private String payeeAccount;
	private Double amount;
	public AccountPaymentDto(String payeeAccount, Double amount) {
		super();
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}
	public String getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public void validate() {
		if (this.payeeAccount == null || this.amount == null) {
			throw new IllegalArgumentException("Missing parameters!");
		}
	}
	
	@Override
	public String toString() {
		return "AccountPaymentDto [payeeAccount=" + payeeAccount + ", amount=" + amount + "]";
	}

}
