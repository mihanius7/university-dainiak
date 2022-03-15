package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.belhard.Person;
import com.belhard.university.util.AccountantUtil;

public class Employee extends Person {
	private LocalDate workingStartDate;
	private double salaryUSD = AccountantUtil.MIN_SALARY_USD;
	
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
	
	public long defineSeniority() {
		return ChronoUnit.YEARS.between(workingStartDate, LocalDate.now());
	}
	
	public double getSalary() {
		return AccountantUtil.defineBonusRatio(this) * salaryUSD;
	}
	
	public void setSalary(double salaryUSD) {
		if (salaryUSD >= AccountantUtil.MIN_SALARY_USD)
			this.salaryUSD = salaryUSD;
		else
			System.out.println("Salary not changed. ");
	}

}
