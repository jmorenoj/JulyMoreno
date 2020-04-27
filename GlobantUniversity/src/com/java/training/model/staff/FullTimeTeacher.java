package com.java.training.model.staff;

public class FullTimeTeacher extends Teacher {

	public FullTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int experienceYears) {
		super(teacherName, personalId, agreementType, baseSalary);
		setExperienceYears(experienceYears);
	}

	@Override
	public double calculateTeacherSalary() {
		return Math.round( getBaseSalary() * 1.1 * getExperienceYears());
	}

}
