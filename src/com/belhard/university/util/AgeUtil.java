package com.belhard.university.util;

import com.belhard.university.entity.person.Employee;
import com.belhard.university.entity.person.Person;
import com.belhard.university.exception.AgeUndefinedException;
import com.belhard.university.exception.SeniorityUndefinedException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeUtil {
    public static int defineAge(Person person) throws AgeUndefinedException {
        if (person.getDateOfBirth() != null) {
            return defineDifference(person.getDateOfBirth(), LocalDate.now());
        } else {
            throw new AgeUndefinedException(person);
        }
    }

    public static int defineSeniorityYears(Employee employee) throws SeniorityUndefinedException {
        if (employee.getWorkingStartDate() != null) {
            return defineDifference(employee.getWorkingStartDate(), LocalDate.now());
        } else {
            throw new SeniorityUndefinedException(employee);
        }
    }

    private static int defineDifference(LocalDate date2, LocalDate date1) {
        return (int) ChronoUnit.YEARS.between(date2, date1);
    }
}
