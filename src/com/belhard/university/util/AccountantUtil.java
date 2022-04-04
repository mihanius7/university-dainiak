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
    public final static BigDecimal MIN_SALARY_USD = BigDecimal.valueOf(75);
    public final static BigDecimal SENIORITY_BONUS_YEAR_FACTOR = BigDecimal.valueOf(1.07);
    public final static BigDecimal SENIORITY_MAX_BONUS_RATIO = BigDecimal.valueOf(2.5);
    public final static BigDecimal HOLIDAY_PAY_RATIO = BigDecimal.valueOf(2.5);

    public final static BigDecimal MASTER_DEGREE_SUPPLEMENT = BigDecimal.valueOf(1.15);
    public final static BigDecimal DOCTOR_DEGREE_SUPPLEMENT = BigDecimal.valueOf(1.3);
    public final static BigDecimal PROFESSOR_DEGREE_SUPPLEMENT = BigDecimal.valueOf(1.45);

    public final static BigDecimal MIN_SCHOLARSHIP = BigDecimal.valueOf(60);
    public final static double SCHOLARSHIP_MIN_AVERAGE_MARK = 5.0;
    public final static double SCHOLARSHIP_AVERAGE_MARK_FACTOR = 1.1;

    private static BigDecimal defineSeniorityBonusRatio(Employee employee) {
        int seniority = 0;
        try {
            seniority = AgeUtil.defineSeniorityYears(employee);
        } catch (SeniorityUndefinedException e) {
            e.printStackTrace();
        }
        BigDecimal bonusRatio = SENIORITY_BONUS_YEAR_FACTOR.pow(seniority);
        if (bonusRatio.compareTo(SENIORITY_MAX_BONUS_RATIO) > 0) {
            bonusRatio = SENIORITY_MAX_BONUS_RATIO;
        }
        return bonusRatio;
    }

    private static BigDecimal defineHolidayPayRatio(Employee employee) {
        return HOLIDAY_PAY_RATIO;
    }

    private static BigDecimal defineDegreeSupplementRatio(Teacher teacher) {
        if (teacher.getDegree() == null) {
            return BigDecimal.ZERO;
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

    private static BigDecimal defineScholarshipRatio(Student student) {
        double scholarshipRatio = SCHOLARSHIP_AVERAGE_MARK_FACTOR * (student.getAverageMark() - SCHOLARSHIP_MIN_AVERAGE_MARK);
        return student.getAverageMark() >= SCHOLARSHIP_MIN_AVERAGE_MARK ? BigDecimal.valueOf(scholarshipRatio)
                : BigDecimal.ZERO;
    }

    public static Money defineCurrentSalary(Employee employee) {
        return new Money(employee.getBaseSalary().getAmount().multiply(defineSeniorityBonusRatio(employee)));
    }

    public static Money defineCurrentSalary(Teacher teacher) {
        BigDecimal asEmployeeSalary = defineCurrentSalary((Employee) teacher).getAmount();
        return new Money(asEmployeeSalary.multiply(defineDegreeSupplementRatio(teacher)));
    }

    public static BigDecimal defineScholarship(Student student) {
        return defineScholarshipRatio(student).multiply(MIN_SCHOLARSHIP);
    }

    public static Money defineHolidayPay(Employee employee) {
        return new Money(defineCurrentSalary(employee).getAmount().multiply(defineHolidayPayRatio(employee)));
    }

    public static Money defineSalary(Department dep) {
        BigDecimal totalSalary = BigDecimal.ZERO;
        if (dep.getCleaner() != null)
            totalSalary = defineCurrentSalary(dep.getCleaner()).getAmount();
        for (Person person : dep.getPersons())
            totalSalary = totalSalary.add(defineCurrentSalary((Teacher) person).getAmount());
        return new Money(totalSalary, Money.Currency.USD);
    }
}