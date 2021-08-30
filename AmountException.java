package com.lti.assignment2;

import org.springframework.stereotype.Component;

@Component
public class AmountException extends Exception{
	
	public AmountException() {
		super("Invalid amount");
	}
}