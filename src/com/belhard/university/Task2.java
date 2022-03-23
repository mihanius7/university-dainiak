package com.belhard.university;

import java.time.LocalDate;

import com.belhard.university.group.StudentGroup;

public class Task2 {

	public static void main(String[] args) {
		Teacher teacher1 = new Teacher("Harry", "Lemetre");
		teacher1.setDegree(AcademicDegree.DOCTOR);
		teacher1.setDateOfBirth(LocalDate.of(1960, 4, 15));
		Teacher teacher2 = new Teacher("Harry", "Lemetre");
		teacher2.setDegree(AcademicDegree.DOCTOR);
		teacher2.setDateOfBirth(LocalDate.of(1960, 4, 15));
		
//		System.out.println(teacher2==teacher1);
		
		StudentGroup cleaner1 = null;
		
		cleaner1 = new StudentGroup("Group 35.B", Faculty.COMPUTER_SCIENCE, teacher1);
		for (int i = 0; i < 100; i++) {
			System.out.println(cleaner1.toString() + "\thash " + cleaner1.hashCode());
		}
	}

}
