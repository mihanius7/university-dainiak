package com.belhard.university;

public class App {

	public static void main(String[] args) {
		Teacher teacher1 = new Teacher("George", "Lemetre");
		Group group1 = new Group("2019A", "Astrophysics", teacher1);

		Student student1 = new Student("Sam", "Sayer", 1995, 10, 10); 
		Student student2 = new Student("Tedd", "Maxwell", 1994, 3, 9);
		Student student3 = new Student("Garry", "Daniels", 1995, 5, 3);
		Student student4 = new Student("Julie", "McCalister", 1996, 1, 30);
		Student student5 = new Student("Sarah", "Connor", 1995, 9, 15);
		Student student6 = new Student("Bill", "Gates", 1995, 4, 21);
		Student student7 = new Student("Anna", "Uta", 1993, 6, 7);

		group1.addStudent(student1);
		group1.addStudent(student2);
		group1.addStudent(student3);
		group1.addStudent(student4);
		group1.addStudent(student5);
		System.out.println(group1.toList());
		group1.removeStudent(student2);
		System.out.println(group1.toList());
		group1.removeStudent(student6);
		System.out.println(group1.toList());
		group1.addStudent(student4);
		System.out.println(group1.toList());
		group1.addStudent(student6);
		group1.addStudent(student7);
		System.out.println(group1.toList());
		
		System.out.println(student3.getDateOfBirthString());

	}

}
