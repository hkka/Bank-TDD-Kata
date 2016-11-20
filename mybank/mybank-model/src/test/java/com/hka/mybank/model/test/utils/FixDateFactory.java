package com.hka.mybank.model.test.utils;

import java.time.LocalDateTime;

import com.hka.mybank.model.utils.DateFactory;

/**
 * @DateFactory implementation for test purpose
 * 
 * It returns always the same date : 2016 11 20 - 14 : 18 : 20
 * 
 * @author MAHASSAN
 *
 */
public class FixDateFactory implements DateFactory {

	@Override
	public LocalDateTime getTime() {		
		return LocalDateTime.of(2016, 11, 20, 14, 18, 20);
	}

}
