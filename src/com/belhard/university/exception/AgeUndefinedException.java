package com.belhard.university.exception;

import com.belhard.Person;

public class AgeUndefinedException extends Exception {
    private final Person person;

    public AgeUndefinedException(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Age undefined: " +
                person.getClass().getSimpleName().toLowerCase() + " " + person.getFirstName() + " " + person.getLastName();
    }
}
