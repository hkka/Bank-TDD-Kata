package com.hka.mybank.model.test.utils;

import java.util.Random;

public class AccountTestingUtils {
	
	private static Double minDouble = 0.0;
	private static Double maxDouble = Double.MAX_VALUE;
	
	private static Long minLong = 0l;
	private static Long maxLong = Long.MAX_VALUE;
	
	/**
	 * Generate random @Double greater than zero
	 * 
	 * @return Double value
	 */
	public static Double generateAnyDoubleGreaterThanZero(){
		Double generatedDouble = minDouble + new Random().nextDouble() * (maxDouble - minDouble);
		return generatedDouble;
	}
	
	/**
	 *  Generate random Long greater than zero
	 *  
	 * @return Long value
	 */
	public static Long generateAnyLongGreaterThanZero(){		
		Long generatedLong = minLong + new Random().nextLong() * (maxLong - minLong);
		return generatedLong;
		
	}

}
