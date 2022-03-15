package com.belhard.university.util;

import com.belhard.university.Employee;
import com.belhard.university.Student;
import com.belhard.university.Teacher;

public class AccountantUtil {
	public final static double BONUS_YEAR_FACTOR = 1.075;
	public final static double MAX_BONUS_RATIO = 5.0;
	public final static double HOLIDAY_PAY_RATIO = 2.5;
	public final static double MASTER_DEGREE_SUPPLEMENT_ = 1.3;
	public final static double DOCTOR_DEGREE_SUPPLEMENT_ = 1.6;
	public final static double PROFESSOR_DEGREE_SUPPLEMENT_ = 1.9;
	public final static double SCHOLARSHIP_MIN_AVERAGE_MARK = 5.0;
	public final static double SCHOLARSHIP_AVERAGE_MARK_FACTOR = 1.1;

	public static double defineBonus(Employee employee) {
		double bonusRatio = BONUS_YEAR_FACTOR * employee.defineSeniority();
		if (bonusRatio > MAX_BONUS_RATIO)
			bonusRatio = MAX_BONUS_RATIO;
		return bonusRatio * employee.getSalary();
	}

	public static double defineHolidayPay(Employee employee) {
		return HOLIDAY_PAY_RATIO * employee.getSalary();
	}

	public static double defineDegreeSupplement(Teacher teacher) {
		return -1;
	}

	public static double defineScholarship(Student student) {
		if (student.getAverageMark() >= SCHOLARSHIP_MIN_AVERAGE_MARK)
			return SCHOLARSHIP_AVERAGE_MARK_FACTOR * (student.getAverageMark() - SCHOLARSHIP_MIN_AVERAGE_MARK);
		return 0;
	}
}
