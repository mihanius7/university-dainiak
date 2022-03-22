package com.belhard.university.group;

import com.belhard.Person;
import com.belhard.university.Student;
import com.belhard.university.Teacher;

public class StudentGroup extends Group {

	Teacher teacher;
	String faculty;

	public StudentGroup(String groupName, String faculty, Teacher teacher) {
		super(groupName);
		this.faculty = faculty;
		this.teacher = teacher;
	}

	public void addStudent(Person newStudent) {
		super.addPerson(newStudent);
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Person getStudent() {
		return persons[currentPersonsCount - 1];
	}

	public String getGroupName() {
		return groupName;
	}

	public int getCurrentStudentsCount() {
		return currentPersonsCount;
	}

	public String getFaculty() {
		return faculty;
	}

	public double defineAverageMark() {
		double averageMark = 0;
		for (int i = 0; i < currentPersonsCount; i++)
			averageMark += ((Student) persons[i]).getAverageMark() / currentPersonsCount;
		return averageMark;
	}

	public String toList() {
		Student student;
		String output = "\n" + getInfo() + "\n";
		for (int i = 0; i < currentPersonsCount; i++) {
			student = (Student) persons[i];
			if (student != null)
				output = output.concat(student.toString() + "\n");
			else
				output = output.concat("null");
		}
		output = output.concat("Average mark: "
				+ String.format("%.2f", defineAverageMark())+ ". ");
		return output;
	}
	
	@Override
	public String toString() {
		return toList();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
