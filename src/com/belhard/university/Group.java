package com.belhard.university;

public class Group {

	private String groupName;
	private final Student[] students;
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
			if (newStudent != null)
				if (!this.hasStudent(newStudent))
					students[currentStudentsCount++] = newStudent;
				else
					System.out.println(newStudent.getFirstName() + " is already in group " + groupName);
			else
				System.out.println("Can't add 'null' student!");
		} else
			System.out.println(newStudent.getFirstName() + " wasn't added to group " + groupName + ". Group is full.");
	}

	public Student[] getStudents() {
		return students.clone();
	}

	public boolean removeStudent(Student student) {
		boolean removed = false;
		if (student != null) {
			for (int i = 0; i < currentStudentsCount; i++) {
				if (students[i].getId() == student.getId()) {
					students[i] = null;
					currentStudentsCount--;
					removed = true;
					System.out.println("Student " + student.getFirstName() + " was removed");
				}
				if (removed && students[i + 1] != null) {
					students[i] = students[i + 1];
				}
			}
			if (!removed)
				System.out.println("There isn't " + student.getFirstName() + " in group " + groupName);
		}
		return removed;
	}

	public Student getStudent(long studentId) {
		for (int i = 0; i < currentStudentsCount; i++) {
			if (students[i].getId() == studentId) {
				return students[i];
			}
		}
		System.out.println("Student [" + studentId + "] is not found in group " + groupName);
		return null;
	}

	public boolean hasStudent(Student student) {
		boolean found = false;
		for (int i = 0; i < currentStudentsCount; i++) {
			if (students[i].getId() == student.getId()) {
				found = true;
				break;
			}
		}
		return found;

	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	public double defineAverageMark() {
		double averageMark = 0;
		for (int i = 0; i < currentStudentsCount; i++)
			averageMark += students[i].getAverageMark() / currentStudentsCount;
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
		for (int i = 0; i < currentStudentsCount; i++) {
			student = students[i];
			if (student != null)
				output = output.concat(
						"[" + student.getId() + "]" + "\t" + student.getFirstName() + "\t\t" + student.getLastName()
								+ "\t\t" + student.defineAge() + "\t" + student.getAverageMark() + "\n");
			else
				output = output.concat("null");
		}
		int vacantPlaces = MAX_STUDENTS_COUNT - currentStudentsCount;
		output = output.concat("GROUP SUMMARY: students " + currentStudentsCount + ", avg. mark: "
				+ String.format("%.2f", defineAverageMark()) + ", can accept " + vacantPlaces + " students.\n");
		return output;
	}

}
