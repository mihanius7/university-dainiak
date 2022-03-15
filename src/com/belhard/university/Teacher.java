package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Teacher extends Person {
	private String department;
	private LocalDate startTeachingDate;

	public Teacher(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public Teacher(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public LocalDate getStartTeachingDate() {
		return startTeachingDate;
	}

	public void setStartTeachingDate(int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		this.startTeachingDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);;
	}

	public long defineSeniority() {
		return ChronoUnit.YEARS.between(startTeachingDate, LocalDate.now());
	}

}
