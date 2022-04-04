package com.belhard.university.entity.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.belhard.university.entity.person.auxiliary.Faculty;
import com.belhard.university.exception.AgeUndefinedException;

public class Student extends Person {
    private Faculty faculty;
    private double averageMark;
    private LocalDate studyStartDate;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        if (averageMark >= 0 && averageMark <= 10) {
            this.averageMark = averageMark;
        } else {
            throw new RuntimeException("Mark " + averageMark + " isn't valid. Current average mark " + this.averageMark);
//            System.out.println("Mark " + averageMark + " isn't valid. Current average mark " + this.averageMark);
        }
    }

    public void setStudyStartDate(int year, int month, int day) {
        this.studyStartDate = LocalDate.of(year, month, day);
    }

    public long defineYearOfStudy() {
        if (studyStartDate != null)
            return ChronoUnit.YEARS.between(studyStartDate, LocalDate.now()) + 1;
        else
            return -1;//FIXME throw
    }

    @Override
    public String toString() {
        String output = "Student ";
        output = output.concat(super.toString());
        output = output.concat("Average mark " + averageMark);
        return output;
    }

    @Override
    public String introduceYourself() {
        int age;
        try {
            age = defineAge();
        } catch (AgeUndefinedException e) {
            throw new RuntimeException("Age undefined, id: " + id);
        }
        return String.format(
                "Hi! My name is %s. I am %d years old and I'm a student %nof %s faculty on %d-th year of study. My average mark is %.1f.%n", getFirstName(),
                age, faculty.toString().toLowerCase(), defineYearOfStudy(), averageMark);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) averageMark * 100;
        result = 31 * result + (studyStartDate == null ? 0 : studyStartDate.hashCode());
        result = 31 * result + (faculty == null ? 0 : faculty.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return super.equals(obj) && Objects.equals(studyStartDate, other.studyStartDate) && Objects.equals(faculty, other.faculty)
                && averageMark == other.averageMark;
    }

}
