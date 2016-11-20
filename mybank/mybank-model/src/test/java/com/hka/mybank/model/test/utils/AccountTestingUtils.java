package com.hka.mybank.model.test.utils;

import java.util.Random;

/**
 * Provides Some Utils functions to AccountTest class
 * 
 * @author MAHASSAN
 *
 */
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
	 * Generate a Double greater than the passed argument @minValue
	 * 
	 * @param minValue
	 * @return Double value
	 */
	public static Double generateAnyDoubleGreaterThanGivenDouble(Double minValue){
		Double generatedDouble = minValue + new Random().nextDouble() * (maxDouble - minValue);
		return generatedDouble;
	}
	
	/**
	 * Generate a Double below the passed argument @maxValue
	 * 
	 * @param minValue
	 * @return Double value
	 */
	public static Double generateAnyDoubleBelowGivenDouble(Double maxValue){
		Double generatedDouble = minDouble + new Random().nextDouble() * (maxValue - minDouble);
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
