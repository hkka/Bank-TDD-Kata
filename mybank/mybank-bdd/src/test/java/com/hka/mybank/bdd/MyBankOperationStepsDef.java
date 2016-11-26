package com.hka.mybank.bdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

import com.hka.mybank.bdd.utils.FixDateFactory;
import com.hka.mybank.bdd.utils.MyBankBDDUtils;
import com.hka.mybank.exception.api.MyBankErrorInfo;
import com.hka.mybank.exception.api.MyBankException;
import com.hka.mybank.model.Account;
import com.hka.mybank.model.Client;
import com.hka.mybank.model.Operation;
import com.hka.mybank.model.utils.DateFactory;

import static org.assertj.core.api.Assertions.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * operations.feature bdd scenario steps definition
 * 
 * @author MAHASSAN
 *
 */
public class MyBankOperationStepsDef {
	
	private static final String DEPOSIT_OPERATION = "deposit";
	private static final String WITHDRAW_OPERATION = "retrieve";
	private DateFactory testDateFactory = new FixDateFactory();
	
	// contains the operations that will be done during the current BDD scenario
	private Stream<Operation> clientOperationsOccuredDuringBddScenario;
	
	// expected operations at the end of the current BDD scenario
	private ArrayList<Operation> expectedOperations = new ArrayList<Operation>();
	
	Long accountNumber = 1l;
	
	private Account acc;
	private Client c;
	
	private MyBankException myBankExcp;

	@Given("^a MyBank client with (\\d+) as account balance$")
	public void a_MyBank_client_with_as_account_balance(int accountBalance) throws Throwable {
	    acc = new Account(accountNumber, 1.0 * accountBalance);
	    Account.df = testDateFactory;
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
	    assertThat(c.getAccount().getBalance()).isEqualTo(expectedBalance);
	}
	
	@Then("^a mybankexception is thrown with error message \"([^\"]*)\"$")
	public void a_mybankexception_is_thrown_with_error_message(String arg1) throws Throwable {
	    assertThat(myBankExcp).isNotNull();
	    assertThat(myBankExcp.getMessage()).isEqualTo(MyBankErrorInfo.INSUFFUCIENT_FUNDS.message());
	}
	
	@When("^i check my operations$")
	public void i_check_my_operations() throws Throwable {		clientOperationsOccuredDuringBddScenario = c.getAccount().getOperations();
	    
	}
	
	@Then("^i can see$")
	public void i_can_see(List<Map<String, String>> data) throws Throwable {		
		
		data.stream().forEach(item -> {								
										Operation o = new Operation();
										MyBankBDDUtils.updateOperationFieldsFromBddFeatureData(o, item);
										expectedOperations.add(o);
									}
		);
		
		System.out.println("----------------------------------------------------");
		System.out.println("Retrieved opreations form OPERATIONS.FEATURE file : ");
		expectedOperations.stream().forEach(o -> System.out.println(o));
		System.out.println("----------------------------------------------------");
		
		int matchingOperations = clientOperationsOccuredDuringBddScenario.filter(o -> expectedOperations.contains(o)).collect(Collectors.toList()).size();
	    assertThat(matchingOperations).isEqualTo(expectedOperations.size());
	    
	}
	
}
