package com.hka.mybank.model.test.utils;

import java.util.Random;
import java.util.stream.Stream;

import com.hka.mybank.model.Client;
import com.hka.mybank.model.Operation;

/**
 * Provides Some Utils functions to ClientTest class
 * 
 * @author MAHASSAN
 *
 */
public class ClientTestingUtils {
	
	public static Stream<Operation> doSomeOperationsOnClientAccount(Client c){
		
		new Random().nextInt(10);
		
		
		
		
		return c.getAccount().getOperations();
	}

}
