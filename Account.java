package com.lti.assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Account {
	
	private double balance;
	
	@Autowired
	private BalanceException balexp;
	
	@Autowired
	private AmountException amtexp;
	
	public Account() {
		this(1000);
	}
	
	
	public Account(double amt) {
		this.balance=amt;
		System.out.println("Account created successfully with balance : "+balance);
		
	}
	
	public double deposit(double amount) throws AmountException {
		if(amount<0) {
			throw amtexp;
		}
		else {
			balance+=amount;
		}
		return balance;
	}
	
	public double withdraw(double amount) throws AmountException, BalanceException {
		if(amount<0) {
			throw amtexp;
		}
		if(balance<amount) {
			throw balexp;
		}
		else {
			balance-=amount;
		}
		
		return balance;
	}
}
