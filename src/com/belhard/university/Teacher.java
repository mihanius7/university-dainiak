package com.belhard.university;

import java.util.Objects;

import com.belhard.university.util.AccountantUtil;
import com.belhard.university.util.Money;

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

	public String getSubjectsString() {
		String output = "";
		if (subjects != null) {
			for (int i = 0; i < subjects.length; i++) {
				if (i > 0)
					output = output.concat(", ");
				output = output.concat(subjects[i]);

			}
			output = output.concat(". ");
		}
		return output;
	}

	@Override
	public String toString() {
		String output = (degree != null) ? degree.toString().toLowerCase() + " " : "";
		output = output.concat(super.toString());
		Money currentSalary = AccountantUtil.defineCurrentSalary(this);
		Money holidayPay = AccountantUtil.defineHolidayPay(this);
		output = output.concat("Salary: current " + currentSalary + ", holiday pay " + holidayPay);
		getSubjectsString();
		return output;
	}

	@Override
	public String introduceYourself() {
		String output = String.format("Hello! My name is %s %s. I am %d years old. I am a %s. %nI am teaching %s%n",
				firstName, lastName, defineAge(), degree.toString().toLowerCase(), getSubjectsString());
		return output;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (degree == null ? 0 : degree.hashCode());
		result = 31 * result + (department == null ? 0 : department.hashCode());
		result = 31 * result + (subjects == null ? 0 : subjects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return super.equals(obj) && Objects.equals(degree, other.degree) && Objects.equals(department, other.department)
				&& Objects.equals(subjects, other.subjects);
	}

}
