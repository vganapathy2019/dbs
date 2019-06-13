package com.dbs.payment.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.AccountNotFoundException;
import com.dbs.payment.InsufficientFundsException;
import com.dbs.payment.application.service.PaymentService;
import com.dbs.payment.controller.dto.AccountPaymentDto;
import com.dbs.payment.controller.dto.EmailPaymentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
public class PaymentRestController {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/payments/payment-to-email/{payer-account}", method = RequestMethod.POST, consumes = "application/json") 
	@ResponseStatus(HttpStatus.OK)
	public void payToEmail(@PathVariable("payer-account") String payerAccount, @RequestBody EmailPaymentDto dto) {
		System.out.println(dto);
		dto.validate();
		paymentService.paymentToEmail(payerAccount, dto.getPayeeEmail(), dto.getAmount());
	}
	
	@RequestMapping(value = "/payments/payment-to-account/{payer-account}", method = RequestMethod.POST, consumes = "application/json") 
	@ResponseStatus(HttpStatus.OK)
	public void payToAccount(@PathVariable("payer-account") String payerAccount, @RequestBody AccountPaymentDto dto) {
		System.out.println(dto);
		dto.validate();
		paymentService.paymentToAccount(payerAccount, dto.getPayeeAccount(), dto.getAmount());	
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleInvalidRateRequestException(IllegalArgumentException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody String handleAccountNotFoundException(AccountNotFoundException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(InsufficientFundsException.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
	public @ResponseBody String handleInsufficientFundsException(InsufficientFundsException exception) {
		return exception.getMessage();
	}

}
