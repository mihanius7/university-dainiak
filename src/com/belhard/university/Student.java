package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.belhard.Person;

public class Student extends Person {
	private Faculty faculty;
	private double averageMark;
	private LocalDate studyStartDate;

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Student(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
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

	public void setStudyStartDate(int year, int month, int day) {
		this.studyStartDate = LocalDate.of(year, month, day);
	}

	public long defineYearOfStudy() {
		if (studyStartDate != null)
			return ChronoUnit.YEARS.between(studyStartDate, LocalDate.now());
		else
			return -1;
	}

	@Override
	public String toString() {
		String output = "Student ";
		output = output.concat(super.toString());
		output = output.concat("Average mark " + averageMark);
		return output;
	}

	@Override
	public String introduceYourself() {
		String output = String.format(
				"Hi! My name is %s. I am %d years old and I'm a student %nof %s faculty during %d years.%n", firstName,
				defineAge(), faculty.toString().toLowerCase(), defineYearOfStudy());
		return output;
	}

	@Override
	public int hashCode() {
		int result = (int) id;
		result = 31 * result + defineAge();
		result = 31 * result + (int) averageMark;
		result = 31 * result + (firstName == null ? 0 : firstName.hashCode());
		result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
