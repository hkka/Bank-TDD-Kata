package com.hka.mybank.bdd.deposit;

import org.junit.Assert;

import com.hka.mybank.model.Account;
import com.hka.mybank.model.Client;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepositOperationStepsDef {
	
	Long accountNumber = 1l;
	
	private Account acc;
	private Client c;

	@Given("^a MyBank client with (\\d+) as account balance$")
	public void a_MyBank_client_with_as_account_balance(int accountBalance) throws Throwable {
	    acc = new Account(accountNumber, 1.0 * accountBalance);
	    c = new Client(acc);
	}

	@When("^i deposit (\\d+)$")
	public void i_deposit(int depositAmount) throws Throwable {
		Double doubleDepositAmount = 1.0 * depositAmount;
	    c.deposit(doubleDepositAmount);
	}

	@Then("^my account balance is (\\d+)$")
	public void my_account_balance_is(int balance) throws Throwable {
		Double expectedBalance = 1.0 * balance;
	    Assert.assertEquals(expectedBalance, c.getAccount().getBalance());
	}
}
