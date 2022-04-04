package com.belhard.university;

import com.belhard.university.entity.person.Teacher;
import com.belhard.university.entity.person.auxiliary.Money;

import java.math.BigDecimal;

public class Task2 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Jack", "Compton");
        t1.setDegree(Teacher.AcademicDegree.MASTER);
        t1.setWorkingStartDate(2017, 9, 1);
        t1.setDateOfBirth(1995, 7, 21);
        t1.setBaseSalary(new Money(BigDecimal.valueOf(100)));
        t1.setSubjects(new String[]{"Math", "Astronomy"});
        System.out.println(t1);
        System.out.println(t1.introduceYourself());
    }
}
