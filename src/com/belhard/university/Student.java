package com.belhard.university;

public class Student extends Person {
	private String faculty;
	private double averageMark;

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Student(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
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

	public String toString() {
		String output = "Student ";
		output = output.concat(super.toString());
		output = output.concat("Average mark " + averageMark);
		return output;
	}

}
