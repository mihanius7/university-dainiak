package com.belhard.university;

import java.time.LocalDate;

import com.belhard.university.group.StudentGroup;

public class Task2 {

	public static void main(String[] args) {
		Teacher teacher1 = new Teacher("Harry", "Lemetre");
		teacher1.setDegree(AcademicDegree.DOCTOR);
		teacher1.setDateOfBirth(LocalDate.of(1960, 4, 15));
		for (int i = 0; i < 100; i++) {
			StudentGroup cleaner1 = new StudentGroup("Group 35.B", Faculty.COMPUTER_SCIENCE, teacher1);
			System.out.println(cleaner1.toString() + "\thash " + cleaner1.hashCode());
		}
	}

}
