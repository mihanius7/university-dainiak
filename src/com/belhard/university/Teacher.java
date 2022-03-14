package com.belhard.university;

import java.time.LocalDate;

public class Teacher {
	private static long count = 1;
	private long id;
	private String firstName, lastName;
	private String faculty;
	private LocalDate dateOfBirth;

	public Teacher(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		id = count++;
	}

	public Teacher(String firstName, String lastName, String faculty) {
		this(firstName, lastName);
		this.faculty = faculty;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
