package com.belhard.university.exception;

import com.belhard.Person;

public class SeniorityUndefinedException extends Exception {
    private final Person person;

    public SeniorityUndefinedException(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Seniority undefined: " +
                person.getClass().getSimpleName().toLowerCase() + " " + person.getFirstName() + " " + person.getLastName();
    }
}
