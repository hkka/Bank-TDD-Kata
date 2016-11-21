package com.hka.mybank.model.test;


import org.junit.Assert;
import org.junit.Test;

import com.hka.mybank.model.Operation;
import com.hka.mybank.model.OperationType;
import com.hka.mybank.model.test.utils.FixDateFactory;
import com.hka.mybank.model.utils.DateFactory;

public class OperationComparisonTest {
	
	private DateFactory testDateFactory = new FixDateFactory();
	
	@Test
	public void ShouldReturnTrueForTwoSameOperationObjects(){
		Operation o1 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), 10.0, 50.0);
		Operation o2 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), 10.0, 50.0);
		
		boolean comparingTwoSameOperationsResult = o1.equals(o2);
		
		Assert.assertTrue(comparingTwoSameOperationsResult);
	}
	
	@Test
	public void ShouldReturnFalseForTwoOperationsObjectsWithDifferentTypes(){
		// type is DEPOSIT
		Operation o1 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), 10.0, 50.0);
		// type is WITHDRAW
		Operation o2 = new Operation(OperationType.WITHDRAW, testDateFactory.getTime(), 10.0, 50.0);
		
		boolean comparingTwoSameOperationsResult = o1.equals(o2);
		
		Assert.assertFalse(comparingTwoSameOperationsResult);
	}
	
	@Test
	public void ShouldReturnFalseForTwoOperationsObjectsWithDifferentAmounts(){
		// Amount is 10
		Operation o1 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), 10.0, 50.0);
		// Amount is 1
		Operation o2 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), 1.0, 50.0);
		
		boolean comparingTwoSameOperationsResult = o1.equals(o2);
		
		Assert.assertFalse(comparingTwoSameOperationsResult);
	}
	
	@Test
	public void ShouldReturnFalseForTwoOperationsObjectsWithDifferentCurrentBalance(){
		// balance is 50
		Operation o1 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), 10.0, 50.0);
		// balance is 5
		Operation o2 = new Operation(OperationType.DEPOSIT, testDateFactory.getTime(), 10.0, 5.0);
		
		boolean comparingTwoSameOperationsResult = o1.equals(o2);
		
		Assert.assertFalse(comparingTwoSameOperationsResult);
	}

}
