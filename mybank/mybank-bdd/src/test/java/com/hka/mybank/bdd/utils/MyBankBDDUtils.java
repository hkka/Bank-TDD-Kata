package com.hka.mybank.bdd.utils;

import java.util.Map;

import com.hka.mybank.model.Operation;
import com.hka.mybank.model.OperationType;
import com.hka.mybank.model.utils.DateFactory;

/**
 * Utilities class offering useful operations for MBank BDD scenarii
 * 
 * @author MAHASSAN
 *
 */
public class MyBankBDDUtils {
	
	private static DateFactory testDateFactory = new FixDateFactory();
	
	/**
	 * Update passed @o operation object fields with values in the second parameter @data
	 * 
	 * @param o Operation object to update
	 * @param data Map<String, String> of Operation fields (type, amount, balance) and their values
	 */
	static public void updateOperationFieldsFromBddFeatureData(Operation o, Map<String, String> data){
		
		data.forEach( (k,v) -> {	
						switch (k) {
						case "type":	{	
							if(v.equals("deposit"))
								o.setType(OperationType.DEPOSIT);
							else
								o.setType(OperationType.WITHDRAW);
							}										
							break;
						case "amount":	{o.setAmount(Double.valueOf(v));}										
							break;
						case "balance":	{o.setCurrentBalance(Double.valueOf(v));}										
							break;
						case "date":	{o.setDate(testDateFactory.getTime());}										
							break;
			
						default:
							break;
						}													
					}
	);
		
		o.setDate(testDateFactory.getTime());
		
	}

}
