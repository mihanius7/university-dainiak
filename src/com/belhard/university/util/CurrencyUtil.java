package com.belhard.university.util;

import java.math.BigDecimal;

public class CurrencyUtil {
	public static final double BYN_TO_USD = 0.30;
	public static final double BYN_TO_EUR = 0.27;
	public static final double BYN_TO_RUR = 30.17;

	public static final double USD_TO_BYN = 3.28;
	public static final double USD_TO_EUR = 0.90;
	public static final double USD_TO_RUR = 100.61;

	public static final double EUR_TO_BYN = 3.65;
	public static final double EUR_TO_USD = 1.11;
	public static final double EUR_TO_RUR = 111.96;
	
	public static final double RUR_TO_BYN = 0.0326;
	public static final double RUR_TO_USD = 0.0099;
	public static final double RUR_TO_EUR = 0.0089;

	public static Money convertToUSD(Money money) {
		Money output;
		if (money.getCurrency() == Currency.BYN) {
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(BYN_TO_USD)), Currency.USD);
			return output;
		} else if (money.getCurrency() == Currency.EUR) {			
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(EUR_TO_USD)), Currency.USD);
			return output;
		} else if (money.getCurrency() == Currency.RUR) {			
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(RUR_TO_USD)), Currency.USD);
			return output;
		} 
		else
			return null;
	}
	
	public static Money convertToEUR(Money money) {
		Money output;
		if (money.getCurrency() == Currency.BYN) {
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(BYN_TO_EUR)), Currency.EUR);
			return output;
		} else if (money.getCurrency() == Currency.USD) {			
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(USD_TO_EUR)), Currency.EUR);
			return output;
		} else if (money.getCurrency() == Currency.RUR) {			
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(RUR_TO_EUR)), Currency.EUR);
			return output;
		} 
		else
			return null;
	}
	
	public static Money convertToRUR(Money money) {
		Money output;
		if (money.getCurrency() == Currency.BYN) {
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(BYN_TO_RUR)), Currency.RUR);
			return output;
		} else if (money.getCurrency() == Currency.USD) {			
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(USD_TO_RUR)), Currency.RUR);
			return output;
		} else if (money.getCurrency() == Currency.EUR) {			
			output = new Money(money.getAmount().multiply(BigDecimal.valueOf(EUR_TO_RUR)), Currency.RUR);
			return output;
		} 
		else
			return null;
	}

}
