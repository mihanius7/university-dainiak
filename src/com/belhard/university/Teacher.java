package com.belhard.university;

public class Teacher extends Employee {
	private String department;
	private String[] subjects;

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

	public String[] getSubjects() {
		return subjects.clone();
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public String toString() {
		String output = "Teacher ";
		output = output.concat(super.toString());
		output = output.concat("Seniority " + defineSeniority() + " years. ");
		if (subjects != null) {
			output = output.concat("\n\tSUBJECTS: ");
			for (int i = 0; i < subjects.length; i++) {
				if (i > 0)
					output = output.concat(", ");
				output = output.concat(subjects[i]);
			}
			output = output.concat(". ");
		}
		return output;
	}

}
