package com.belhard.university.entity.person.auxiliary;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	public static final String DOUBLE_FORMAT = "%.2f ";
	BigDecimal amount;
	Currency currency;

	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Money(BigDecimal amount) {
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
		this.currency = newCurrency;
	}

	public String toString() {
		return String.format(DOUBLE_FORMAT, amount) + currency.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(currency, other.currency);
	}

	public enum Currency {
		USD, BYN, RUR, EUR
	}
}
