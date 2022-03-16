package com.belhard.university;

import java.time.LocalDate;

import com.belhard.Address;

public class App {

	public static void main(String[] args) {
		Teacher teacher1 = new Teacher("Harry", "Lemetre");
		teacher1.setDegree(AcademicDegree.DOCTOR);
		teacher1.setWorkingStartDate(1987, 9, 1);
		teacher1.setSubjects(new String[] { "Astrophysics", "Physics", "Cosmology" });
		teacher1.setBaseSalary(450);
		Teacher teacher2 = new Teacher("Edwin", "Hubble");
		teacher2.setDegree(AcademicDegree.PROFESSOR);
		teacher2.setWorkingStartDate(1983, 10, 2);
		teacher2.setSubjects(new String[] { "Math", "Astrophysics", "Physics", "Earth remote sensing" });
		teacher2.setBaseSalary(450);
		Cleaner cleaner1 = new Cleaner("Timmy", "Bear");
		cleaner1.setRoomsForCleaning(new String[] {"303", "304-1", "304-2", "223", "225", "227"});
		cleaner1.setWorkingStartDate(2018, 8, 15);
		cleaner1.setBaseSalary(275);
		StudentGroup studentGroup = new StudentGroup("2019A", "Astrophysics", teacher1);

		Student student1 = new Student("Sam", "Sayer", 1995, 10, 10);
		Student student2 = new Student("Tedd", "Maxwell", 1994, 3, 9);
		Student student3 = new Student("Garry", "Daniels", 1995, 5, 3);
		Student student4 = new Student("Julie", "Thomson", 1996, 1, 30);
		Student student5 = new Student("Sarah", "Connor", 1995, 9, 15);
		Student student6 = new Student("Bill", "Gates", 1995, 4, 21);
		Student student7 = new Student("Anna", "Uta", 1993, 6, 7);
		student1.setAverageMark(9.1);
		student2.setAverageMark(7.0);
		student3.setAverageMark(8.5);
		student4.setAverageMark(9.8);
		student5.setAverageMark(6.1);
		student6.setAverageMark(9.1);
		student7.setAverageMark(8.7);

		studentGroup.addStudent(student1);
		studentGroup.addStudent(student2);
		studentGroup.addStudent(student3);
		studentGroup.addStudent(student4);
		studentGroup.addStudent(student5);
		System.out.println(studentGroup.toList());
		studentGroup.removePerson(student2);
		System.out.println(studentGroup.toList());
		studentGroup.removePerson(student6);
		studentGroup.setTeacher(teacher2);
		System.out.println(studentGroup.toList());
		studentGroup.addStudent(student4);
		System.out.println(studentGroup.toList());
		studentGroup.addStudent(student6);
		studentGroup.addStudent(student7);
		System.out.println(studentGroup.toList());

		student1.setAddress(new Address("Belarus", "Minsk", "Kalvaryjskaja str.", 32, 118));
		student2.setAddress(new Address("Poland", "Katowice", "ul. Jana Pawla II", 9));
		teacher1.setAddress(new Address("Italy", "Rome", "via Nazionale", 13));
		teacher1.setDateOfBirth(LocalDate.of(1960, 4, 15));

		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student4);
		System.out.println(teacher2);
		System.out.println(teacher1);
		System.out.println(cleaner1);
	}

}
