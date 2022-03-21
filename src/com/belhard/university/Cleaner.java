package com.belhard.university;

import com.belhard.university.util.AccountantUtil;
import com.belhard.university.util.Money;

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
					output = output.concat(", ");
				output = output.concat(roomsForCleaning[i]);
			}
			output = output.concat(". ");
		}
		return output;
	}

	public void setRoomsForCleaning(String[] roomsForCleaning) {
		this.roomsForCleaning = roomsForCleaning;
	}

	public String toString() {
		String output = "Cleaner ";
		output = output.concat(super.toString());
		Money currentSalary = AccountantUtil.defineCurrentSalary(this);
		Money holidayPay = AccountantUtil.defineHolidayPay(this);
		output = output.concat("Salary: current " + currentSalary + ", holiday pay " + holidayPay);
		getRoomsForCleaningString();
		return output;
	}

	@Override
	public String introduceYourself() {
		String output = String.format(
				"Hello! My name is %s. I am %d years old. Now I'm a cleaner. I like %nmy work because I have free mind and can to listen podcasts simultaneously. %nI must clean the folowing rooms: %s%n",
				firstName, defineAge(), getRoomsForCleaningString().toLowerCase());
		return output;
	}

}
