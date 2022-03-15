package com.belhard;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
	private static long count = 1L;
	private long id;
	String firstName, lastName;
	LocalDate dateOfBirth;
	Address address;

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

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirthString() {
		return firstName + " " + lastName + " was born in " + dateOfBirth;
	}

	public long defineAge() {
		if (dateOfBirth != null)
			return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
		else
			return 0;
	}

	public String toString() {
		String output = "[" + id + "] " + firstName.toUpperCase() + " " + lastName.toUpperCase() + ". ";
		int age = (int) defineAge();
		if (age > 0)
			output = output.concat(defineAge() + " years old. ");
		else
			output = output.concat("Age undefined. ");
		if (address != null)
			output = output.concat(address.toString());
		else
			output = output.concat("Adress undefined. ");
		return output;
	}

}
