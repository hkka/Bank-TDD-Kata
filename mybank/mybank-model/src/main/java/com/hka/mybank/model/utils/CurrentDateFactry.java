package com.hka.mybank.model.utils;

import java.time.LocalDateTime;

public class CurrentDateFactry implements DateFactory {
	
	@Override
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}

}
