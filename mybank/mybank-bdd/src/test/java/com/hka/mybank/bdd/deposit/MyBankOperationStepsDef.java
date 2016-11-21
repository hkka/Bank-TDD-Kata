package com.hka.mybank.bdd.deposit;

import org.junit.Assert;

import com.hka.mybank.exception.api.MyBankErrorInfo;
import com.hka.mybank.exception.api.MyBankException;
import com.hka.mybank.model.Account;
import com.hka.mybank.model.Client;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyBankOperationStepsDef {
	
	private static final String DEPOSIT_OPERATION = "deposit";
	private static final String WITHDRAW_OPERATION = "retrieve";
	
	Long accountNumber = 1l;
	
	private Account acc;
	private Client c;
	
	private MyBankException myBankExcp;

	@Given("^a MyBank client with (\\d+) as account balance$")
	public void a_MyBank_client_with_as_account_balance(int accountBalance) throws Throwable {
	    acc = new Account(accountNumber, 1.0 * accountBalance);
	    c = new Client(acc);
	}
	
	@When("^i \"([^\"]*)\" (\\d+)$")
	public void i(String operation, int operationAmount) throws Throwable {
		Double doubleOperationAmount = 1.0 * operationAmount;
		
		if(operation.equals(DEPOSIT_OPERATION))
			c.deposit(doubleOperationAmount);
		else if(operation.equals(WITHDRAW_OPERATION)){
			try {
				c.withDraw(doubleOperationAmount);
			} catch (MyBankException e) {
				myBankExcp = e;
			}
		}
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
	
	@Then("^a mybankexception is thrown with error message \"([^\"]*)\"$")
	public void a_mybankexception_is_thrown_with_error_message(String arg1) throws Throwable {
	    Assert.assertNotNull(myBankExcp);
	    Assert.assertEquals(MyBankErrorInfo.INSUFFUCIENT_FUNDS.message(), myBankExcp.getMessage());
	}
}
