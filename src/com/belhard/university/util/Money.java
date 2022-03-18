package com.belhard.university.util;

import java.math.BigDecimal;

public class Money {
	BigDecimal amount;
	Currency currency;
	public static final String DOUBLE_FORMAT = "%.2f ";

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
	
	public String toString() {
		return String.format(DOUBLE_FORMAT, amount) + currency.toString();
	}
}
