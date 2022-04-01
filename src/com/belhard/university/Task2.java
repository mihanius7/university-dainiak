package com.belhard.university;

public class Task2 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("Jack", "Compton");
        t1.setDegree(AcademicDegree.MASTER);
        t1.setSubjects(new String[] {"Math", "Astronomy"});
        System.out.println(t1);
    }
}
