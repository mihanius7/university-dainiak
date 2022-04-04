package com.belhard.university.entity.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.belhard.university.entity.Identifiable;
import com.belhard.university.entity.person.auxiliary.Address;
import com.belhard.university.exception.AgeUndefinedException;

public abstract class Person implements Identifiable {
    private static long count = 1L;
    final Long id;
    final String firstName;
    String lastName;
    private LocalDate dateOfBirth;
    private Address address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        id = count++;
    }

    public Person(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this(firstName, lastName);
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirthString() {
        return firstName + " " + lastName + " was born in " + dateOfBirth;
    }

    public int defineAge() throws AgeUndefinedException {//FIXME move to util
        if (dateOfBirth != null) {
            return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
        } else {
            throw new AgeUndefinedException(this);
        }
    }

    public abstract String introduceYourself();

    @Override
    public String toString() {
        String output = "[" + id + "] " + firstName.toUpperCase() + " " + lastName.toUpperCase() + ". ";
        if (dateOfBirth != null) {
            output += defineAge() + " years old. ";
        }
        if (address != null) {
            output += address;
        }
        return output;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + (dateOfBirth == null ? 0 : dateOfBirth.hashCode());
        result = 31 * result + (address == null ? 0 : address.hashCode());
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
        Person other = (Person) obj;
        return Objects.equals(id, other.id) && Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
                && Objects.equals(address, other.address);
    }

}
