package com.java.training.model;

public abstract class Teacher {

	private String teacherName;
	private int personalId;
	private int teacherCode;
	private static int increase = 1000;
	private String agreementType;
	private double baseSalary;
	private int experienceYears;
	private int activeHours;

	public Teacher(String teacherName, int personalId, String agreementType, double baseSalary) {
		setTeacherName(teacherName);
		setPersonalId(personalId);
		setTeacherCode(generateTeacherCode());
		setAgreementType(agreementType);
		setBaseSalary(baseSalary);

	}

	public abstract double calculateTeacherSalary();

	public void printTeachersList() {
		if (agreementType == "Full Time") {
			System.out.print("Teacher Code: " + this.teacherCode + " | ");
			System.out.print("Teacher Name: " + this.teacherName + " | ");
			System.out.print("Personal Id: " + this.personalId + " | ");
			System.out.print("Type of Agreement: " + this.agreementType + " | ");
			System.out.print("Base salary: " + this.baseSalary + " | ");
			System.out.print("Experience Years: " + this.experienceYears + " | ");
			System.out.println("Salary: " + this.calculateTeacherSalary());
		} else if (agreementType == "Part Time") {
			System.out.print("Teacher Code: " + this.teacherCode + " | ");
			System.out.print("Teacher Name: " + this.teacherName + " | ");
			System.out.print("Personal Id: " + this.personalId + " | ");
			System.out.print("Type of Agreement: " + this.agreementType + " | ");
			System.out.print("Base salary: " + this.baseSalary + " | ");
			System.out.print("Active Hours per month: " + this.activeHours + " | ");
			System.out.println("Salary: " + this.calculateTeacherSalary());
		} else {
			System.out.println("Type of Agreement doesn't exist");
		}
	}

	public void printTeacher() {
		if (agreementType == "Full Time") {
			System.out.println("Teacher Code: " + this.teacherCode + "\n" +
		    "Teacher Name: " + this.teacherName + "\n" +
			"Personal Id: " + this.personalId + "\n" +
			"Type of Agreement: " + this.agreementType + "\n" +
			"Base salary: " + this.baseSalary + "\n" +
			"Experience Years: " + this.experienceYears + "\n" +
			"Salary: " + this.calculateTeacherSalary());
		} else if (agreementType == "Part Time") {
			System.out.println("Teacher Code: " + this.teacherCode + "\n" +
			"Teacher Name: " + this.teacherName + "\n" +
			"Personal Id: " + this.personalId + "\n" +
			"Type of Agreement: " + this.agreementType + "\n" +
			"Base salary: " + this.baseSalary + "\n" +
			"Active Hours per month: " + this.activeHours + "\n" +
			"Salary: " + this.calculateTeacherSalary());
		} else {
			System.out.println("Type of Agreement doesn't exist");
		}
	}
	
	
	@Override
	public String toString() {
		return this.teacherName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	protected void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getPersonalId() {
		return personalId;
	}

	protected void setPersonalId(int teacherId) {
		this.personalId = teacherId;
	}

	public int getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(int teacherCode) {
		this.teacherCode = teacherCode;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	protected void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	protected void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	public int getActiveHours() {
		return activeHours;
	}

	protected void setActiveHours(int activeHours) {
		this.activeHours = activeHours;
	}

	public String getAgreementType() {
		return agreementType;
	}

	protected void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

	/** This method generate the teacher code */
	private int generateTeacherCode() {
		increase = increase + 1;
		return increase;
	}

}
