package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.belhard.Person;
import com.belhard.university.util.AccountantUtil;

public abstract class Employee extends Person {
	private LocalDate workingStartDate;
	double baseSalary = AccountantUtil.MIN_SALARY_USD;

	public Employee(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public LocalDate getWorkingStartDate() {
		return workingStartDate;
	}

	public void setWorkingStartDate(int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		this.workingStartDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public long defineSeniorityYears() {
		if (workingStartDate != null)
			return ChronoUnit.YEARS.between(workingStartDate, LocalDate.now());
		else
			return -1;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary >= AccountantUtil.MIN_SALARY_USD)
			this.baseSalary = baseSalary;
		else
			System.out.println("Base salary not changed. ");
	}

	public String toString() {
		String output = super.toString() + "\n\t";
		output = output.concat("Seniority " + defineSeniorityYears() + " years. ");
		return output;
	}

}
