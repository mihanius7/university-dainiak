package com.belhard.university;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.belhard.Person;
import com.belhard.university.exception.SeniorityUndefinedException;
import com.belhard.university.util.AccountantUtil;
import com.belhard.university.util.Currency;
import com.belhard.university.util.CurrencyUtil;
import com.belhard.university.util.Money;

public abstract class Employee extends Person {
    private LocalDate workingStartDate;
    Money baseSalary = new Money(AccountantUtil.MIN_SALARY_USD, Currency.USD);

    public Employee(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(firstName, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public LocalDate getWorkingStartDate() {
        return workingStartDate;
    }

    public void setWorkingStartDate(int year, int month, int day) {
        this.workingStartDate = LocalDate.of(year, month, day);
    }

    public int defineSeniorityYears() throws SeniorityUndefinedException {
        if (workingStartDate != null)
            return (int) ChronoUnit.YEARS.between(workingStartDate, LocalDate.now());
        else
            throw new SeniorityUndefinedException(this);
    }

    public Money getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Money newSalary) {
        if (newSalary.getCurrency() != Currency.USD) {
            newSalary.setAmount(CurrencyUtil.convertToUSD(newSalary));
        }
        if (newSalary.getAmount().doubleValue() >= AccountantUtil.MIN_SALARY_USD)
            this.baseSalary.setAmount(newSalary);
        else
            System.out.println("Base salary not changed. ");
    }

    @Override
    public String toString() {
        String output = super.toString() + "\n";
        try {
            output = output.concat("Seniority " + defineSeniorityYears() + " years. ");
        } catch (SeniorityUndefinedException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (baseSalary == null ? 0 : baseSalary.hashCode());
        result = 31 * result + (workingStartDate == null ? 0 : workingStartDate.hashCode());
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
        Employee other = (Employee) obj;
        return super.equals(obj) && Objects.equals(workingStartDate, other.workingStartDate)
                && Objects.equals(baseSalary, other.baseSalary);
    }

}