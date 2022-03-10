package com.belhard.university;

public class Teacher {

	long id;
	private String firstName, lastName;
	private String faculty;
	private int age;
	private String skill;

	public Teacher(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		id = (long) Math.random() * 1000;
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

}
