package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
	private static long count = 1L;
	private long id;
	private String firstName, lastName;
	private LocalDate dateOfBirth;
	private Address address;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		id = count++;
	}

	public Person(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		this(firstName, lastName);
		this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDateOfBirthString() {
		return firstName + " " + lastName + " was born in " + dateOfBirth;
	}

	public long defineAge() {
		if (dateOfBirth != null)
			return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
		else {
			System.out.println("Age undefined for " + firstName + " " + lastName);
			return 0;
		}
	}

}
