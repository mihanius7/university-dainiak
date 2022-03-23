package com.belhard.university.group;

import java.util.Objects;

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
		addPerson(newTeacher);
	}

	public Teacher getManager() {
		return manager;
	}

	public Teacher getTeacher(int index) {
		return (Teacher) getPerson(index);
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
		for (int i = 0; i < getCurrentPersonCount(); i++) {
			teacher = getTeacher(i);
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
		int result = super.hashCode();
		result = 31 * result + (cleaner == null ? 0 : cleaner.hashCode());
		result = 31 * result + (manager == null ? 0 : manager.hashCode());
		result = 31 * result + (managerDeputy == null ? 0 : managerDeputy.hashCode());
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
		Department other = (Department) obj;
		return super.equals(obj) && Objects.equals(cleaner, other.cleaner) && Objects.equals(manager, other.manager)
				&& Objects.equals(managerDeputy, other.managerDeputy);
	}

}
