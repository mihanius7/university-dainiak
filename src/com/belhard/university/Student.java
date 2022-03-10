package com.belhard.university;

public class Student {

	long id;
	private String firstName, lastName;
	private String faculty;
	private int age;
	private double averageMark;

	public Student(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		id = (long) (Math.random() * 1000);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

}
