package com.belhard.university.util;

import java.math.BigDecimal;

import com.belhard.Person;
import com.belhard.university.Employee;
import com.belhard.university.Student;
import com.belhard.university.Teacher;
import com.belhard.university.datastructures.MyArray;
import com.belhard.university.group.Department;

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
		double bonusRatio = Math.pow(SENIORITY_BONUS_YEAR_FACTOR, employee.defineSeniorityYears());
		if (bonusRatio > SENIORITY_MAX_BONUS_RATIO)
			bonusRatio = SENIORITY_MAX_BONUS_RATIO;
		return bonusRatio;
	}

	private static double defineHolidayPayRatio(Employee employee) {
		return HOLIDAY_PAY_RATIO;
	}

	private static double defineDegreeSupplementRatio(Teacher teacher) {
		double supplementRatio = 0;
		if (teacher.getDegree() != null) {
			switch (teacher.getDegree()) {
			case MASTER:
				supplementRatio = MASTER_DEGREE_SUPPLEMENT;
				break;
			case DOCTOR:
				supplementRatio = DOCTOR_DEGREE_SUPPLEMENT;
				break;
			case PROFESSOR:
				supplementRatio = PROFESSOR_DEGREE_SUPPLEMENT;
				break;
			default:
				System.out.println(
						"Degree pupplement for " + teacher.getFirstName() + teacher.getLastName() + "is not defined.");
				break;
			}
		}
		return supplementRatio;
	}

	private static double defineScholarshipRatio(Student student) {
		if (student.getAverageMark() >= SCHOLARSHIP_MIN_AVERAGE_MARK)
			return (SCHOLARSHIP_AVERAGE_MARK_FACTOR) * (student.getAverageMark() - SCHOLARSHIP_MIN_AVERAGE_MARK);
		return 0;
	}

	public static Money defineCurrentSalary(Employee employee) {
		return new Money(employee.getBaseSalary().getAmount().doubleValue() * defineSeniorityBonusRatio(employee));
	}

	public static Money defineCurrentSalary(Teacher teacher) {
		return new Money(defineCurrentSalary((Employee) teacher).getAmount().doubleValue()
				+ defineDegreeSupplementRatio(teacher) * teacher.getBaseSalary().getAmount().doubleValue());
	}

	public static double defineScholarship(Student student) {
		return MIN_SCHOLARSHIP * defineScholarshipRatio(student);
	}

	public static Money defineHolidayPay(Employee employee) {
		return new Money(defineHolidayPayRatio(employee) * defineCurrentSalary(employee).getAmount().doubleValue());
	}

	public static Money defineSalary(Department dep) {
		MyArray persons = dep.getPersons();
		int count = dep.getCurrentPersonCount();
		BigDecimal totalSalary = BigDecimal.valueOf(0.0);
		if (dep.getCleaner() != null)
			totalSalary = defineCurrentSalary(dep.getCleaner()).getAmount();
		for (int i = 0; i < count; i++)
			totalSalary = totalSalary.add(defineCurrentSalary((Teacher) dep.getTeacher(i)).getAmount());
		return new Money(totalSalary, Currency.USD);
	}

}
