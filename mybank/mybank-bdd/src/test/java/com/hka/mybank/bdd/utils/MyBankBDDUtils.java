package com.hka.mybank.bdd.utils;

import java.util.Map;

import com.hka.mybank.model.Operation;
import com.hka.mybank.model.OperationType;
import com.hka.mybank.model.utils.DateFactory;

public class MyBankBDDUtils {
	
	private static DateFactory testDateFactory = new FixDateFactory();
	
	static public void buildOperationFromBddFeatureData(Operation o, Map<String, String> data){
		
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
