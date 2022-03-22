package com.belhard.university.group;

import com.belhard.Person;
import com.belhard.university.Identifiable;

public abstract class Group implements Identifiable {
	private static long count = 1L;
	private long id;
	String groupName;
	final Person[] persons;
	int currentPersonsCount;
	public static final int MAX_PERSONS_COUNT = 8;

	public Group(String groupName) {
		this.groupName = groupName;
		persons = new Person[MAX_PERSONS_COUNT];
		currentPersonsCount = 0;
		id = count++;
	}

	public void addPerson(Person newPerson) {
		if (currentPersonsCount < MAX_PERSONS_COUNT) {
			if (newPerson != null)
				if (!this.hasPerson(newPerson))
					persons[currentPersonsCount++] = newPerson;
				else
					System.out.println(newPerson.getFirstName() + " is already in group " + groupName);
			else
				System.out.println("Can't add 'null' student!");
		} else
			System.out.println(newPerson.getFirstName() + " wasn't added to group " + groupName + ". Group is full.");
	}

	public Person[] getPersons() {
		return persons.clone();
	}
	
	public long getId() {
		return id;
	}

	public boolean removePerson(Person person) {
		boolean removed = false;
		if (person != null) {
			for (int i = 0; i < currentPersonsCount; i++) {
				if (persons[i].getId() == person.getId()) {
					persons[i] = null;
					currentPersonsCount--;
					removed = true;
					System.out.println("Student " + person.getFirstName() + " was removed");
				}
				if (removed && persons[i + 1] != null) {
					persons[i] = persons[i + 1];
				}
			}
			if (!removed)
				System.out.println("There isn't " + person.getFirstName() + " in group " + groupName);
		}
		return removed;
	}

	public Person getPerson(long personId) {
		for (int i = 0; i < currentPersonsCount; i++) {
			if (persons[i].getId() == personId) {
				return persons[i];
			}
		}
		System.out.println("Student [" + personId + "] is not found in group " + groupName);
		return null;
	}

	public boolean hasPerson(Person person) {
		boolean found = false;
		for (int i = 0; i < currentPersonsCount; i++) {
			if (persons[i].getId() == person.getId()) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public int getCurrentPersonCount() {
		return currentPersonsCount;
	}

	public String getInfo() {
		String output = "";
		int vacantPlaces = MAX_PERSONS_COUNT - currentPersonsCount;
		output = output.concat("GROUP: " + groupName + ". Persons " + currentPersonsCount + ", can accept "
				+ vacantPlaces + " persons. ");
		return output;
	}
	
	public abstract String toList();

}
