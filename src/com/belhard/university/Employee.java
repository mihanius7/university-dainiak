package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.belhard.Person;
import com.belhard.university.util.AccountantUtil;
import com.belhard.university.util.Currency;
import com.belhard.university.util.CurrencyUtil;
import com.belhard.university.util.Money;

public abstract class Employee extends Person {
	private LocalDate workingStartDate;
	Money baseSalary = new Money(AccountantUtil.MIN_SALARY_USD);

	public Employee(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public LocalDate getWorkingStartDate() {
		return workingStartDate;
	}

	public void setWorkingStartDate(int year, int month, int day) {
		this.workingStartDate = LocalDate.of(year, month, day);
	}

	public long defineSeniorityYears() {
		if (workingStartDate != null)
			return ChronoUnit.YEARS.between(workingStartDate, LocalDate.now());
		else
			return -1;
	}

	public Money getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Money newSalary) {
		if (newSalary.getCurrency() != Currency.USD) {
			newSalary.setAmount(CurrencyUtil.convertToUSD(newSalary));
		}
		if (newSalary.getAmount().doubleValue() >= AccountantUtil.MIN_SALARY_USD)
			this.baseSalary.setAmount(newSalary);
		else
			System.out.println("Base salary not changed. ");
	}

	public String toString() {
		String output = super.toString() + "\n\t";
		output = output.concat("Seniority " + defineSeniorityYears() + " years. ");
		return output;
	}

}
