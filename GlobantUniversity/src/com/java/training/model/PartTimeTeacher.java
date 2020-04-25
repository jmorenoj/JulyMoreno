package com.java.training.model;

public class PartTimeTeacher extends Teacher {

	public PartTimeTeacher(String teacherName, int personalId,String agreementType, double baseSalary, int activeHours) {
		super(teacherName, personalId,agreementType, baseSalary);
		setActiveHours(activeHours);
	}

	@Override
	public double calculateTeacherSalary() {
		return getBaseSalary() * getActiveHours();
	}

}
