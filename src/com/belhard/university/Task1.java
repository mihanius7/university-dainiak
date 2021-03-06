package com.belhard.university;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.belhard.university.entity.person.auxiliary.Address;
import com.belhard.university.entity.person.Cleaner;
import com.belhard.university.entity.person.auxiliary.Faculty;
import com.belhard.university.entity.person.Student;
import com.belhard.university.entity.person.Teacher;
import com.belhard.university.entity.group.Department;
import com.belhard.university.entity.group.StudentGroup;
import com.belhard.university.entity.person.auxiliary.Money;

public class Task1 {

    public static void main(String[] args) {

        //Departments
        Teacher teacher1 = new Teacher("Harry", "Lemetre");
        teacher1.setDegree(Teacher.AcademicDegree.DOCTOR);
        teacher1.setDateOfBirth(1960, 4, 15);
        teacher1.setWorkingStartDate(1987, 9, 1);
        teacher1.setAddress(new Address("Italy", "Rome", "via Nazionale", 13));
        teacher1.setSubjects(new String[]{"Astrophysics", "Physics", "Cosmology"});
        teacher1.setBaseSalary(new Money(BigDecimal.valueOf(450)));
        Teacher teacher2 = new Teacher("Edwin", "Hubble");
        teacher2.setDegree(Teacher.AcademicDegree.PROFESSOR);
        teacher2.setWorkingStartDate(1983, 10, 2);
        teacher2.setSubjects(new String[]{"Math", "Astrophysics", "Physics", "Earth remote sensing"});
        teacher2.setBaseSalary(new Money(BigDecimal.valueOf(450)));
        Teacher teacher3 = new Teacher("Ludwig", "Alaskin");
        teacher3.setDegree(Teacher.AcademicDegree.MASTER);
        teacher3.setDateOfBirth(1985, 7, 11);
        teacher3.setWorkingStartDate(2010, 1, 10);
        teacher3.setSubjects(new String[]{"Math", "Computer science"});
        teacher3.setBaseSalary(new Money(BigDecimal.valueOf(330)));
        Cleaner cleaner1 = new Cleaner("Timmy", "Bear");
        cleaner1.setDateOfBirth(1990, 8, 7);
        cleaner1.setRoomsForCleaning(new String[]{"303", "304-1", "304-2", "223", "225", "227"});
        cleaner1.setWorkingStartDate(2018, 8, 15);
        cleaner1.setBaseSalary(new Money(BigDecimal.valueOf(240), Money.Currency.EUR));
        Department department1 = new Department("Astrophysics and Theoretical Physics", teacher2);
        department1.addTeacher(teacher1);
        System.out.println(department1.toList());
        department1.addTeacher(teacher3);
        department1.setCleaner(cleaner1);
        System.out.println(department1.toList());

        //Students group
        StudentGroup studentGroup = new StudentGroup("2019A", Faculty.PHYSICS, teacher1);
        Student student1 = new Student("Sam", "Sayer", 1995, 10, 10);
        Student student2 = new Student("Tedd", "Maxwell", 1994, 3, 9);
        Student student3 = new Student("Garry", "Daniels", 1995, 5, 3);
        Student student4 = new Student("Julie", "Thomson", 1996, 1, 30);
        Student student5 = new Student("Sarah", "Connor", 1995, 9, 15);
        Student student6 = new Student("Bill", "Gates", 1995, 4, 21);
        Student student7 = new Student("Anna", "Uta", 1993, 6, 7);
        student1.setAverageMark(9.1);
        student1.setAddress(new Address("Belarus", "Minsk", "Kalvaryjskaja str.", 32, 118));
        student1.setStudyStartDate(2017, 9, 1);
        student1.setFaculty(Faculty.PHYSICS);
        student2.setAverageMark(7.0);
        student2.setAddress(new Address("Poland", "Katowice", "ul. Jana Pawla II", 9));
        student2.setStudyStartDate(2017, 9, 1);
        student2.setFaculty(Faculty.PHYSICS);
        student3.setAverageMark(8.5);
        student3.setStudyStartDate(2017, 9, 1);
        student3.setFaculty(Faculty.BIOLOGY);
        student4.setAverageMark(9.8);
        student4.setStudyStartDate(2017, 9, 1);
        student4.setFaculty(Faculty.BIOLOGY);
        student5.setAverageMark(6.1);
        student5.setStudyStartDate(2016, 9, 1);
        student5.setFaculty(Faculty.COMPUTER_SCIENCE);
        student6.setAverageMark(9.1);
        student6.setStudyStartDate(2016, 9, 1);
        student6.setFaculty(Faculty.COMPUTER_SCIENCE);
        student7.setAverageMark(8.7);
        student7.setStudyStartDate(2016, 9, 1);
        student7.setFaculty(Faculty.PHYSICS);
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
        studentGroup.addStudent(student6);
        studentGroup.addStudent(student7);
        System.out.println(studentGroup.toList());

        //Introducing
        System.out.println();
        System.out.println(student2.introduceYourself());
        System.out.println(cleaner1.introduceYourself());
        System.out.println(teacher3.introduceYourself());
    }
}
