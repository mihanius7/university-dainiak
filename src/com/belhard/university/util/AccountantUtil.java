package com.belhard.university.util;

import java.math.BigDecimal;

import com.belhard.university.entity.person.auxiliary.Money;
import com.belhard.university.entity.person.Person;
import com.belhard.university.entity.person.Employee;
import com.belhard.university.entity.person.Student;
import com.belhard.university.entity.person.Teacher;
import com.belhard.university.exception.SeniorityUndefinedException;
import com.belhard.university.entity.group.Department;

public class AccountantUtil {
    public static final double MIN_SALARY_USD = 250;
    public final static double SENIORITY_BONUS_YEAR_FACTOR = 1.07;
    public final static double SENIORITY_MAX_BONUS_RATIO = 2.5;
    public final static double HOLIDAY_PAY_RATIO = 2.5;

    public final static double MASTER_DEGREE_SUPPLEMENT = 1.15;
    public final static double DOCTOR_DEGREE_SUPPLEMENT = 1.3;
    public final static double PROFESSOR_DEGREE_SUPPLEMENT = 1.45;

    public final static double MIN_SCHOLARSHIP = 60;
    public final static double SCHOLARSHIP_MIN_AVERAGE_MARK = 5.0;
    public final static double SCHOLARSHIP_AVERAGE_MARK_FACTOR = 1.1;

    private static double defineSeniorityBonusRatio(Employee employee) {
        long seniority = 0;
        try {
            seniority = employee.defineSeniorityYears();
        } catch (SeniorityUndefinedException e) {
            e.printStackTrace();
        }
        double bonusRatio = Math.pow(SENIORITY_BONUS_YEAR_FACTOR, seniority);
        if (bonusRatio > SENIORITY_MAX_BONUS_RATIO) {
            bonusRatio = SENIORITY_MAX_BONUS_RATIO;
        }
        return bonusRatio;
    }

    private static double defineHolidayPayRatio(Employee employee) {
        return HOLIDAY_PAY_RATIO;
    }

    private static double defineDegreeSupplementRatio(Teacher teacher) {
        if (teacher.getDegree() == null) {
            return 0;
        }
        switch (teacher.getDegree()) {
            case MASTER:
                return MASTER_DEGREE_SUPPLEMENT;
            case DOCTOR:
                return DOCTOR_DEGREE_SUPPLEMENT;
            case PROFESSOR:
                return PROFESSOR_DEGREE_SUPPLEMENT;
            default:
                throw new RuntimeException("Degree supplement for " + teacher.getFirstName() + teacher.getLastName() + "is not defined.");
        }
    }

    private static double defineScholarshipRatio(Student student) {
        return student.getAverageMark() >= SCHOLARSHIP_MIN_AVERAGE_MARK ?
           (SCHOLARSHIP_AVERAGE_MARK_FACTOR) * (student.getAverageMark() - SCHOLARSHIP_MIN_AVERAGE_MARK) : 0;
    }

    public static Money defineCurrentSalary(Employee employee) {
        return new Money(employee.getBaseSalary().getAmount() * defineSeniorityBonusRatio(employee));
    }

    public static Money defineCurrentSalary(Teacher teacher) {
        return new Money(defineCurrentSalary((Employee) teacher).getAmount().doubleValue()
                + defineDegreeSupplementRatio(teacher) * teacher.getBaseSalary().getAmount().doubleValue());
    }

    public static double defineScholarship(Student student) {
        return MIN_SCHOLARSHIP * defineScholarshipRatio(student);
    }

    public static Money defineHolidayPay(Employee employee) {
        return new Money(
                defineHolidayPayRatio(employee) * defineCurrentSalary(employee).getAmount().doubleValue());
    }

    public static Money defineSalary(Department dep) {
        BigDecimal totalSalary = BigDecimal.valueOf(0.0);
        if (dep.getCleaner() != null)
            totalSalary = defineCurrentSalary(dep.getCleaner()).getAmount();
        for (Person person : dep.getPersons())
            totalSalary = totalSalary.add(defineCurrentSalary((Teacher) person).getAmount());
        return new Money(totalSalary, Money.Currency.USD);
    }

}
