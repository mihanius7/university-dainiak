package com.belhard.university.entity.person;

import com.belhard.university.entity.person.auxiliary.Money;
import com.belhard.university.exception.AgeUndefinedException;
import com.belhard.university.util.AccountantUtil;

import java.util.Objects;

public class Cleaner extends Employee {

    public String[] roomsForCleaning;

    public Cleaner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Cleaner(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public String[] getRoomsForCleaning() {
        return roomsForCleaning.clone();
    }

    public String getRoomsForCleaningString() {
        String output = "";
        if (roomsForCleaning != null) {
            for (int i = 0; i < roomsForCleaning.length; i++) {
                if (i > 0)
                    output += ", ";
                output += roomsForCleaning[i];
            }
            output += ". ";
        }
        return output;
    }

    public void setRoomsForCleaning(String[] roomsForCleaning) {
        this.roomsForCleaning = roomsForCleaning;
    }

    public String toString() {
        String output = "Cleaner ";
        output += super.toString();
        Money currentSalary = AccountantUtil.defineCurrentSalary(this);
        Money holidayPay = AccountantUtil.defineHolidayPay(this);
        output += "Salary: current " + currentSalary + ", holiday pay " + holidayPay;
        getRoomsForCleaningString();
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
                "Hello! My name is %s. I am %d years old. Now I'm a cleaner. I like %nmy work because I have free mind and can to listen podcasts simultaneously. %nI must clean the folowing rooms: %s%n",
                firstName, age, getRoomsForCleaningString().toLowerCase());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result;
        result = 31 * result + (firstName == null ? 0 : firstName.hashCode());
        result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
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
        Cleaner other = (Cleaner) obj;
        return super.equals(obj) && Objects.equals(roomsForCleaning, other.roomsForCleaning);
    }
}