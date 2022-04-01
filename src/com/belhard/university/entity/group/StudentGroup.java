package com.belhard.university.entity.group;

import java.util.Objects;

import com.belhard.university.entity.person.Person;
import com.belhard.university.entity.person.auxiliary.Faculty;
import com.belhard.university.entity.person.Student;
import com.belhard.university.entity.person.Teacher;

public class StudentGroup extends Group {
    private Teacher teacher;
    private Faculty faculty;

    public StudentGroup(String groupName, Faculty faculty, Teacher teacher) {
        super(groupName);
        this.faculty = faculty;
        this.teacher = teacher;
    }

    public void addStudent(Student newStudent) {
        addPerson(newStudent);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher != null)
            this.teacher = teacher;
    }

    public Student getStudent(int index) {
        return (Student) getPerson(index);
    }

    public String getGroupName() {
        return groupName;
    }

    public int getCurrentStudentsCount() {
        return getCurrentPersonCount();
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public double defineAverageMark() {
        double averageMark = 0;
        if (!persons.isEmpty()) {
            for (Person student : persons)
                averageMark += ((Student) student).getAverageMark() / persons.size();
        }
        return averageMark;
    }

    public String toList() {
        String output = "\n" + getInfo() + "\n";
        for (Person student : persons)
            output = output.concat(student.toString() + "\n");
        output = output.concat("Average mark: " + String.format("%.2f", defineAverageMark()) + ". ");
        return output;
    }

    @Override
    public String toString() {
        return toList();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (teacher == null ? 0 : teacher.hashCode());
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
        StudentGroup other = (StudentGroup) obj;
        return super.equals(obj) && Objects.equals(faculty, other.faculty) && Objects.equals(teacher, other.teacher);
    }

}