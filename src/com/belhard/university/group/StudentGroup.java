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

	public String getInfo() {
		return "GROUP: " + groupName + ", FACULTY: " + faculty + ", TEACHER: " + teacher.getFirstName() + " "
				+ teacher.getLastName();
	}

	public String toList() {
		Student student;
		String output = "";
		System.out.println("\n" + getInfo());
		System.out.println("id\tFirst name\tLast name\tAge\tAverage mark");
		for (int i = 0; i < currentPersonsCount; i++) {
			student = (Student) persons[i];
			if (student != null)
				output = output.concat(
						"[" + student.getId() + "]" + "\t" + student.getFirstName() + "\t\t" + student.getLastName()
								+ "\t\t" + student.defineAge() + "\t" + student.getAverageMark() + "\n");
			else
				output = output.concat("null");
		}
		int vacantPlaces = MAX_PERSONS_COUNT - currentPersonsCount;
		output = output.concat("GROUP SUMMARY: students " + currentPersonsCount + ", avg. mark: "
				+ String.format("%.2f", defineAverageMark()) + ", can accept " + vacantPlaces + " students.\n");
		return output;
	}

}
