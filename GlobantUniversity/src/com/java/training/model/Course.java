package com.java.training.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.java.training.model.staff.Student;
import com.java.training.model.staff.Teacher;

public class Course {

	private String courseName;
	private int courseCode;
	private static int increase = 0;
	private int classroom;
	private Teacher teacher;
	private List<Student> arrayStudentInCourse;

	private Course(String courseName, int classroom, Teacher teacher) {
		setCourseName(courseName);
		setClassroom(classroom);
		setCourseCode(generateCourseCode());
		setTeacher(teacher);
		arrayStudentInCourse = new ArrayList<Student>();
	}


	public Course(String courseName, int classroom, Teacher teacher, List<Student> arrayStudentInCourse) {
		this(courseName, classroom, teacher);
		for (Student student : arrayStudentInCourse) {
			addStudentToCourse(student);
		}

	}


	public Course(String courseName, int classroom, Teacher teacher, Student... arrayStudent) {
		this(courseName, classroom, teacher);
		addStudentToCourse(arrayStudent);
	}

	/** This method prints the teacher assigned to an specific course */
	public void printAssignedTeacher() {
		this.teacher.printTeacher();
	};

	/** This method print the students enrolled in one course */
	public void printAssignedStudent() {
		Collections.sort(arrayStudentInCourse);
		for (Student student : arrayStudentInCourse)
			student.printStudentsList();
	};

	/** This method print all courses list */
	public void printCourseInformation() {
		System.out.print("Course Code: " + this.courseCode + " | ");
		System.out.print("Course Name: " + this.courseName + " | ");
		System.out.print("Classroom: " + this.classroom + " | ");
		System.out.print("Teacher: " + this.getTeacher().getTeacherName() + " | ");
		System.out.println("Number of Students: " + arrayStudentInCourse.size());
	};

	/** This method print a single course information */
	public String toString() {
		return "Course Code: " + this.courseCode + " \n"
		+"Course Name: " + this.courseName + " \n"
		+"Classroom: " + this.classroom + " \n"
		+"Teacher: " + this.getTeacher().getTeacherName() + " \n"
		+"Number of Students: " + arrayStudentInCourse.size();
	};

	/** This method add one students' array to a course */
	public void addStudentToCourse(List<Student> arrayStudentInCourse) {
		this.arrayStudentInCourse.addAll(arrayStudentInCourse);
	}

	/** This method add a single student to a course */
	public void addStudentToCourse(Student... arrayStudent) {
		for (Student student : arrayStudent)
			if (arrayStudentInCourse.contains(student))
				System.out.println(student.getStudentName() + " is already in the course" + this.getCourseName());
			else
				arrayStudentInCourse.add(student);
	}

	/** Getters and Setters */
	public String getCourseName() {
		return courseName;
	}

	private void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getClassroom() {
		return classroom;
	}

	private void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public int getCourseCode() {
		return courseCode;
	}

	private void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getArrayStudentInCourse() {
		return arrayStudentInCourse;
	}

	/** This method generate the course code */
	private final int generateCourseCode() {
		increase = increase + 1;
		return increase;
	}
}
