package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Student {

	private static long count = 1L;
	private long id;
	private String firstName, lastName;
	private String faculty;
	private double averageMark;
	private LocalDate dateOfBirth;

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		id = count++;
	}

	public Student(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		this(firstName, lastName);
		this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public Student(String firstName, String lastName, LocalDate dateOfBirth) {
		this(firstName, lastName);
		this.dateOfBirth = dateOfBirth;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(double averageMark) {
		if (averageMark >= 0 && averageMark <= 10)
			this.averageMark = averageMark;
		else
			System.out.println("Mark " + averageMark + " isn't valid. Current average mark " + this.averageMark);
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDateOfBirthString() {
		return firstName + " " + lastName + " was born in " + dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long defineAge() {
		return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
	}

}
