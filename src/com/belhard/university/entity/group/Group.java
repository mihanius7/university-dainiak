package com.belhard.university.entity.group;

import com.belhard.university.entity.Identifiable;
import com.belhard.university.entity.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Group implements Identifiable {
    private static long count = 1L;
    protected long id;
    protected String groupName;
    protected final List<Person> persons;
    public static final int MAX_PERSONS_COUNT = 8;

    public Group(String groupName) {
        this.groupName = groupName;
        persons = new ArrayList<>(0);
        id = count++;
    }

    public void addPerson(Person person) {
        if (person == null) {
            throw new RuntimeException("Can't add 'null' person!");
        }
        if (persons.size() >= MAX_PERSONS_COUNT) {
            throw new RuntimeException(person.getFirstName() + " wasn't added to group " + groupName + ". Group is full.");
        }
        if (persons.contains(person)) {
            throw new RuntimeException(person.getFirstName() + " is already in group " + groupName);
        }
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public long getId() {
        return id;
    }

    public boolean removePerson(Person person) {
        return persons.remove(person);
    }

    public Person getPerson(int index) {
        return persons.get(index);
    }

    public boolean hasPerson(Person person) {
        return persons.contains(person);
    }

    public int getCurrentPersonCount() {
        return persons.size();
    }

    public String getInfo() {
        String output = "* * * ";
        int vacantPlaces = MAX_PERSONS_COUNT - getCurrentPersonCount();
        output = output.concat(groupName + ": Persons " + getCurrentPersonCount() + ", can accept "
                + vacantPlaces + " persons * * *");
        return output;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public abstract String toList();

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (groupName == null ? 0 : groupName.hashCode());
        result = 31 * result + getCurrentPersonCount();
        result = 31 * result + persons.hashCode();
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
        Group other = (Group) obj;
        return id == other.id && Objects.equals(persons, other.persons)
                && Objects.equals(groupName, other.groupName);
    }

}