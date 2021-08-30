package com.lti.assignment2;

import org.springframework.stereotype.Component;

@Component
public class BalanceException extends Exception{
	
	public BalanceException() {
		super("Insufficient balance");
	}
}
