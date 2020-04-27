package com.java.training.model.staff;

public class Student implements Comparable<Student> {

	private String studentName;
	private int personalId;
	private int studentCode;
	private static int increase = 2000;
	private int age;

	public Student(String studentName, int personalId, int age) {
		setStudentName(studentName);
		setPersonalId(personalId);
		setStudentCode(generateStudentCode());
		setAge(age);
	}

	/** This method prints all the Student list*/
	public void printStudentsList() {
		System.out.print("Student Code: " + this.studentCode + " | ");
		System.out.print("Student Name: " + this.studentName + " | ");
		System.out.print("Pesonal Id: " + this.personalId + " | ");
		System.out.println("Student Age: " + this.age);
	}

	/** This method prints one single Student */
	public void printStudent() {
		System.out.println(
		"Student Code: " + this.studentCode + "\n" +
		"Student Name: " + this.studentName + "\n" +
		"Pesonal Id: " + this.personalId +	"\n" +
		"Student Age: " + this.age);
	}
	
	/** Getters and Setters*/
	public String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getPersonalId() {
		return personalId;
	}

	private void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

	public int getStudentCode() {
		return studentCode;
	}

	private void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}

	/** This method generate the student code */
	private int generateStudentCode() {
		increase = increase + 1;
		return increase;
	}
	
	/*
	 * This method set the attribute and order in which the students array is going to be sorted
	 * When Collections.sort(arrayStudent) is invoked
	 */
	
	@Override
	public int compareTo(Student student) {
		/* For Ascending order*/
		return this.getStudentCode()-student.getStudentCode();

	}

}
