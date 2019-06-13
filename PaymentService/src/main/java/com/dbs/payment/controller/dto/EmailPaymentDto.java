package com.dbs.payment.controller.dto;

public class EmailPaymentDto {
	private String payeeEmail;
	private Double amount;
	public EmailPaymentDto(String payeeEmail, Double amount) {
		super();
		this.payeeEmail = payeeEmail;
		this.amount = amount;
	}
	public String getPayeeEmail() {
		return payeeEmail;
	}
	public void setPayeeEmail(String payeeEmail) {
		this.payeeEmail = payeeEmail;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void validate() {
		if (this.payeeEmail == null || this.amount == null) {
			throw new IllegalArgumentException("Missing parameters!");
		}
	}
	@Override
	public String toString() {
		return "EmailPaymentDto [payeeEmail=" + payeeEmail + ", amount=" + amount + "]";
	}
}
