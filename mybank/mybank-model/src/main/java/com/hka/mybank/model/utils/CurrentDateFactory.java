package com.hka.mybank.model.utils;

import java.time.LocalDateTime;

public class CurrentDateFactory implements DateFactory {
	
	@Override
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}

}
