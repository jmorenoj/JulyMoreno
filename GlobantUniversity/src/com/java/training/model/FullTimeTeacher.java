package com.java.training.model;

public class FullTimeTeacher extends Teacher {

	public FullTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int experienceYears) {
		super(teacherName, personalId, agreementType, baseSalary);
		setExperienceYears(experienceYears);
	}

	@Override
	public double calculateTeacherSalary() {
		return getBaseSalary() * 1.1 * getExperienceYears();
	}

}
