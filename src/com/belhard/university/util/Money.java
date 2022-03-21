package com.belhard.university.util;

import java.math.BigDecimal;

public class Money {
	public static final String DOUBLE_FORMAT = "%.2f ";
	BigDecimal amount;
	Currency currency;

	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Money(double amount, Currency currency) {
		this.amount = BigDecimal.valueOf(amount);
		this.currency = currency;
	}
	
	public Money(double amount) {
		this(amount, Currency.USD);
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(Money money) {
		this.setAmount(money.getAmount(), money.getCurrency());
	}
	
	public void setAmount(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Currency getCurrency() {
		return currency;
	}	
	
	public void setCurrency(Currency newCurrency) {
		this.currency= newCurrency;
	}	
	
	public String toString() {
		return String.format(DOUBLE_FORMAT, amount) + currency.toString();
	}
}
