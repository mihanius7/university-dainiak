package com.belhard.university.entity.person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.belhard.university.entity.person.auxiliary.Money;
import com.belhard.university.exception.SeniorityUndefinedException;
import com.belhard.university.util.AccountantUtil;
import com.belhard.university.util.CurrencyUtil;

public abstract class Employee extends Person {
    private LocalDate workingStartDate;
    private final Money baseSalary = new Money(BigDecimal.ZERO, Money.Currency.USD);

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
        if (newSalary.getCurrency() != Money.Currency.USD) {
            newSalary.setAmount(CurrencyUtil.convertToUSD(newSalary));
        }
        if (newSalary.getAmount().compareTo(AccountantUtil.MIN_SALARY_USD) >= 0)
            this.baseSalary.setAmount(newSalary);
        else
            System.out.println("Base salary not changed. ");
    }

    @Override
    public String toString() {
        String output = super.toString() + "\n";
        try {
            output += "Seniority " + defineSeniorityYears() + " years. ";
        } catch (SeniorityUndefinedException e) {
            throw new RuntimeException("Seniority undefined, id: " + id);
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