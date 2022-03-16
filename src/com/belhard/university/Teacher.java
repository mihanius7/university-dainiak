package com.belhard.university;

import com.belhard.university.util.AccountantUtil;

public class Teacher extends Employee {
	private String department;
	private AcademicDegree degree;
	private String[] subjects;

	public Teacher(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
	}

	public Teacher(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public AcademicDegree getDegree() {
		return degree;
	}

	public void setDegree(AcademicDegree degree) {
		this.degree = degree;
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
		String output = degree.toString() + " ";
		output = output.concat(super.toString());
		double currentSalary = AccountantUtil.defineCurrentSalary(this);
		double holidayPay = AccountantUtil.defineHolidayPay(this);
		output = output.concat(String.format("Salary, USD: current %.2f, holiday pay %.2f", currentSalary, holidayPay));
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
