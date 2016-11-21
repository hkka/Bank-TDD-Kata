package com.hka.mybank.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {
	
	private OperationType type;
	private LocalDateTime date;
	private Double amount;
	private Double currentBalance;
	
	public Operation(OperationType operationType, LocalDateTime operationTime,
			Double operationAmount, Double accountBalanceAfterOperation) {
		this.type = operationType;
		this.date = operationTime;
		this.amount = operationAmount;
		this.currentBalance = accountBalanceAfterOperation;
	}
	
	public Operation() {
		// TODO Auto-generated constructor stub
	}

	public OperationType getType() {
		return type;
	}
	public void setType(OperationType type) {
		this.type = type;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	@Override
	public int hashCode() {		
		return Objects.hash(this.type, this.currentBalance.byteValue(), this.date, this.amount.byteValue());
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Operation))
			return false;		
		
		return this.hashCode() == obj.hashCode();
	}
	
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Operation ===> [Type] : ");		sb.append(this.type);
		sb.append(" - [date] : ");					sb.append(this.date);
		sb.append(" - [amount] : ");				sb.append(this.amount);
		sb.append(" - [balanceAfter] : ");			sb.append(this.currentBalance);	
		
		return sb.toString();
	}
}
