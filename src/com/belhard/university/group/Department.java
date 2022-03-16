package com.belhard.university.group;

import com.belhard.Person;
import com.belhard.university.Cleaner;
import com.belhard.university.Student;
import com.belhard.university.Teacher;
import com.belhard.university.util.AccountantUtil;

public class Department extends Group {
	Teacher manager;
	Teacher managerDeputy;
	Cleaner cleaner;

	public Department(String name, Teacher manager) {
		super(name);
		this.manager = manager;
	}

	public void addTeacher(Person newTeacher) {
		super.addPerson(newTeacher);
	}

	public Teacher getManager() {
		return manager;
	}

	public void setManager(Teacher manager) {
		this.manager = manager;
	}

	public Teacher getManagerDeputy() {
		return managerDeputy;
	}

	public void setManagerDeputy(Teacher managerDeputy) {
		this.managerDeputy = managerDeputy;
	}

	public Cleaner getCleaner() {
		return cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

	public double defineTotalSalary() {
		double totalSalary = AccountantUtil.defineCurrentSalary(cleaner);
		for (int i = 0; i < currentPersonsCount; i++)
			totalSalary += AccountantUtil.defineCurrentSalary((Teacher) persons[i]);
		return totalSalary;
	}

	public String toList() {
		Teacher teacher;
		String output = "\n" + getInfo() + "\n";
		for (int i = 0; i < currentPersonsCount; i++) {
			teacher = (Teacher) persons[i];
			if (teacher != null)
				output = output.concat(teacher.toString() + "\n");
			else
				output = output.concat("null");
		}
		output = output.concat(
				"Manager is " + manager.getDegree().toString().toLowerCase() + " "+ manager.getFirstName() + " " + manager.getLastName() + ". \n");
		output = output.concat("Total current salary, USD: " + String.format("%.2f", defineTotalSalary()) + ". ");
		return output;
	}

}
