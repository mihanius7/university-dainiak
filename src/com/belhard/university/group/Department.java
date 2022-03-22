package com.belhard.university.group;

import com.belhard.Person;
import com.belhard.university.Cleaner;
import com.belhard.university.Teacher;
import com.belhard.university.util.AccountantUtil;
import com.belhard.university.util.Money;

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

	public Money defineTotalSalary() {
		return AccountantUtil.defineSalary(this);
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
		output = output.concat("Manager is " + manager.getDegree().toString().toLowerCase() + " "
				+ manager.getFirstName() + " " + manager.getLastName() + ". \n");
		if (cleaner != null)
			output = output.concat(cleaner.toString() + "\n");
		output = output.concat("Total current salary: " + defineTotalSalary() + ". ");
		return output;
	}
	
	@Override
	public String toString() {
		return toList();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
