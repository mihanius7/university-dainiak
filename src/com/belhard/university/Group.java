package com.belhard.university;

public class Group {

	private String groupName;
	private Student[] students;
	private Teacher teacher;
	private String faculty;
	private int currentStudentsCount;
	public static final int MAX_STUDENTS_COUNT = 8;

	public Group(String groupName, String faculty, Teacher teacher) {
		this.groupName = groupName;
		this.faculty = faculty;
		students = new Student[MAX_STUDENTS_COUNT];
		currentStudentsCount = 0;
		this.teacher = teacher;
	}

	public void addStudent(Student newStudent) {
		if (currentStudentsCount < MAX_STUDENTS_COUNT) {
			students[currentStudentsCount] = newStudent;
			currentStudentsCount++;
		} else
			System.out.println(newStudent.getFirstName() + " wasn't added to group " + groupName + ". Group is full.");
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent(int index) {
		if (index >= 0 && index < currentStudentsCount)
			return students[index];
		else {
			System.out.println("Student " + index + " isn't found in group " + groupName);
			return null;
		}
	}

	public Student getStudent() {
		return students[currentStudentsCount - 1];
	}

	public String getGroupName() {
		return groupName;
	}

	public int getCurrentStudentsCount() {
		return currentStudentsCount;
	}

	public String getFaculty() {
		return faculty;
	}

	public String toString() {
		Student student;
		String output = "";
		System.out.println("Faculty: " + faculty + ", group name: " + groupName + ", students count: "
				+ currentStudentsCount + ", teacher: " + teacher.getFirstName() + " " + teacher.getLastName() + "\n");
		System.out.println("id\tFirst name\tLast name\tAge\tAverage mark");
		for (int i = 0; i < currentStudentsCount; i++) {
			student = students[i];
			output = output.concat(student.getId() + "\t" + student.getFirstName() + "\t" + student.getLastName() + "\t"
					+ student.getAge() + "\t" + student.getAverageMark() + "\n");
		}
		return output;
	}
}
