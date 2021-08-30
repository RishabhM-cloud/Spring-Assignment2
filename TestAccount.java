package com.lti.assignment2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:ass2.xml")
public class TestAccount {
	
	@Autowired
	private Account acc;
	
	@Test
	public void testValidDeposit() {
		try {
			double amt=acc.deposit(1000);
			System.out.println("Balance after depositing 1000 : "+amt);
		} catch (AmountException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testInvalidDeposit() {
		try {
			acc.deposit(-10);
		} catch (AmountException e) {
			System.out.println(e.getMessage());
		}
	}
	
		
	@Test
	public void testValidWithdraw() {
		try {
			double amt=acc.withdraw(100);
			System.out.println("Balance after withdrawing 100 : "+amt);
		} catch (AmountException | BalanceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testInvalidWithdraw() {
		try {
			acc.withdraw(-10);
		} catch (AmountException | BalanceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testInsufficentWithdraw() {
		try {
			acc.withdraw(2500);
		} catch (AmountException | BalanceException e) {
			System.out.println(e.getMessage());
		}
	}
	

	
}
