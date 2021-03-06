package com.belhard.university.entity.group;

import java.util.Objects;

import com.belhard.university.entity.person.Person;
import com.belhard.university.entity.person.Cleaner;
import com.belhard.university.entity.person.Teacher;
import com.belhard.university.util.AccountantUtil;
import com.belhard.university.entity.person.auxiliary.Money;

public class Department extends Group {
    private Teacher manager;
    private Teacher managerDeputy;
    private Cleaner cleaner;

    public Department(String name, Teacher manager) {
        super(name);
        setManager(manager);
    }

    public void addTeacher(Teacher newTeacher) {
        addPerson(newTeacher);
    }

    public Teacher getManager() {
        return manager;
    }

    public Teacher getTeacher(int index) {
        return (Teacher) getPerson(index);
    }

    public void setManager(Teacher manager) {
        if (manager != null) {
            this.manager = manager;
            addTeacher(this.manager);
        }
    }

    public Teacher getManagerDeputy() {
        return managerDeputy;
    }

    public void setManagerDeputy(Teacher managerDeputy) {
        if (managerDeputy != null) {
            addTeacher(managerDeputy);
            this.managerDeputy = managerDeputy;
        }
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
        String output = "\n" + getInfo() + "\n";
        for (Person teacher : persons)
            output += "TEACHER " + teacher.toString() + "\n";
        if (cleaner != null) {
            output += cleaner + "\n";
        }
        output += "DEPARTMENT MANAGER " + manager.getDegree().toString().toLowerCase() + " "
                + manager.getFirstName() + " " + manager.getLastName() + ". \n";
        output += "Total current salary: " + defineTotalSalary() + ". ";
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