package com.belhard.university;

public class University {

	public static void main(String[] args) {
		Teacher teacher1 = new Teacher("George", "Lemetre");
		Group group1 = new Group("A001", "Astrophysics", teacher1);
		group1.addStudent(new Student("Sam", "Sayer", 22));
		group1.getStudent().setAverageMark(6.1);
		group1.addStudent(new Student("Tedd", "Maxwell", 21));
		group1.getStudent().setAverageMark(9.7);
		group1.addStudent(new Student("Garry", "Daniels", 23));
		group1.getStudent().setAverageMark(5.8);
		group1.addStudent(new Student("Julie", "McCalister", 23));
		group1.getStudent().setAverageMark(8.3);
		group1.addStudent(new Student("Sarah", "Connor", 21));
		group1.getStudent().setAverageMark(9.1);

		System.out.println(group1);

	}

}
