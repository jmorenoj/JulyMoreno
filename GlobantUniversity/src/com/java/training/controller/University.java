/**
* Globant University is a system to track university classes, teachers and students 
*
* @author  July Moreno
* @version 1.0
* @since   2020-04-27 
*/

package com.java.training.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.training.model.FullTimeTeacher;
import com.java.training.model.PartTimeTeacher;
import com.java.training.model.Student;
import com.java.training.model.Teacher;
import com.java.training.model.Course;

public class University {

	private List<Teacher> arrayTeacher;
	private List<Student> arrayStudent;
	private List<Course> arrayCourse;

	Student student1 = new Student("Adriana Guzman", 1022349904, 32);
	Student student2 = new Student("Alberto Robles", 1022349900, 18);
	Student student3 = new Student("Alejandro Agudelo", 1022349901, 30);
	Student student4 = new Student("Andres Acosta", 1022349902, 26);
	Student student5 = new Student("David Suarez", 1022349903, 20);
	Student student6 = new Student("Veronica Oliveto", 1022349916, 21);
	Student student7 = new Student("Ricardo Gonzalez", 1022349917, 19);
	Student student8 = new Student("Patricio Marino", 1022349918, 31);
	Student student9 = new Student("Mauricio Sierra", 1022349919, 27);
	Student student10 = new Student("Mario Celis", 1022349920, 22);

	FullTimeTeacher fullteacher1 = new FullTimeTeacher("Camila Caputo", 1022349906, "Full Time", 1000000, 1);
	FullTimeTeacher fullteacher2 = new FullTimeTeacher("Cesar Bayona", 1022349907, "Full Time", 1000000, 2);
	FullTimeTeacher fullteacher3 = new FullTimeTeacher("David Ortegon", 1022349908, "Full Time", 1000000, 3);
	FullTimeTeacher fullteacher4 = new FullTimeTeacher("Estefania Gomez", 1022349909, "Full Time", 1000000, 4);
	FullTimeTeacher fullteacher5 = new FullTimeTeacher("Fernando Collazos", 1022349910, "Full Time", 1000000, 5);

	PartTimeTeacher partteacher1 = new PartTimeTeacher("Gonzalo Nieto", 1022349911, "Part Time", 100000, 10);
	PartTimeTeacher partteacher2 = new PartTimeTeacher("Guillermo Mugnaini", 1022349912, "Part Time", 100000, 20);
	PartTimeTeacher partteacher3 = new PartTimeTeacher("Hugo Garcia", 1022349913, "Part Time", 100000, 30);
	PartTimeTeacher partteacher4 = new PartTimeTeacher("Jessica Cardona", 1022349914, "Part Time", 100000, 40);
	PartTimeTeacher partteacher5 = new PartTimeTeacher("Jesus Barrios", 1022349915, "Part Time", 100000, 50);

	Course class1 = new Course("algebra", 101, fullteacher1, student1, student8, student10);
	Course class2 = new Course("mathematics", 102, fullteacher2, student2);
	Course class3 = new Course("geometry", 103, fullteacher1, student2, student3, student4);
	Course class4 = new Course("biology", 104, fullteacher1, student1);
	Course class5 = new Course("physics", 105, fullteacher1, student1, student2, student3, student4);
//	Course class6 = new Course("GeometryII", 104, partteacher1, arrayStudent);

	public University() {

		arrayCourse = new ArrayList<Course>();
		arrayCourse.add(class1);
		arrayCourse.add(class2);
		arrayCourse.add(class3);
		arrayCourse.add(class4);
		arrayCourse.add(class5);
//		arrayCourse.add(class6);

		arrayTeacher = new ArrayList<Teacher>();
		arrayTeacher.add(fullteacher1);
		arrayTeacher.add(fullteacher2);
		arrayTeacher.add(fullteacher3);
		arrayTeacher.add(fullteacher4);
		arrayTeacher.add(fullteacher5);
		arrayTeacher.add(partteacher1);
		arrayTeacher.add(partteacher2);
		arrayTeacher.add(partteacher3);
		arrayTeacher.add(partteacher4);
		arrayTeacher.add(partteacher5);

		arrayStudent = new ArrayList<Student>();
		arrayStudent.add(student1);
		arrayStudent.add(student2);
		arrayStudent.add(student3);
		arrayStudent.add(student4);
		arrayStudent.add(student5);

//		class2.addStudentToCourse(student1, student4, student5);
//		class4.addStudentToCourse(student2);
//		class1.addStudentToCourse(arrayStudent);

	}

//****************************************************************************************************************
	/**
	 * Print Methods
	 **/

	/** This method print all teachers in the list arrayTeacher */
	public void printTeachersList() {
		for (int i = 0; i < arrayTeacher.size(); i++) {
			arrayTeacher.get(i).printTeachersList();
		}
	}

	/**
	 * This method print the teacher information according with one teacherCode
	 * given
	 */
	public void printTeacherByCode(int teacherCode) {
		Teacher temTeacher = searchTeacherCode(teacherCode);
		if (temTeacher == null) {
			System.out.println("Teacher doesn't exist - Please review teacher code entered");
		} else {
			temTeacher.printTeacher();
		}
	}

	/** This method print all students in the list arrayStudent */
	public void printStudentsList() {
		for (Student student : arrayStudent)
			student.printStudentsList();

	}

	/**
	 * This method print the student information according with a studentCode given
	 */
	public void printStudentByCode(int studentCode) {
		Student tempStudent = searchStudentCode(studentCode);
		if (tempStudent == null) {
			System.out.println("Student doesn't exist - Please review student's code entered");

		} else {
			tempStudent.printStudent();
		}
	}

	/** This method print all courses in the list arrayCourse */
	public void printCoursesList() {
		for (Course course : arrayCourse) {
			course.printCourseInformation();
		}
	}

	/**
	 * This method print the course information according with a courseCode given
	 */
	public void printCourseByCode(int courseCode) {
		Course tempCourse = searchCourseByCode(courseCode);
		if (tempCourse == null) {
			System.out.println("Course doesn't exist - Please review course's code");
		} else {
			tempCourse.printCourseInformation();
			System.out.println("\n*** Students List ***\n");
			tempCourse.printAssignedStudent();
		}
	}

	/**
	 * This method print all the courses managed by one teacher according with a
	 * teacherCode given
	 */
	public void printCoursesByTeacher(int teacherCode) {

		Teacher tmpTeacher = searchTeacherCode(teacherCode);
		if (tmpTeacher == null) {
			System.out.println("Teacher code doesn't exist - Please review the teacher code entered");
		} else {

			List<String> tempCourses = searchCoursesByTeacher(teacherCode);
			if (tempCourses.size() == 0) {
				System.out.println("Teacher " + tmpTeacher.getTeacherName() + " is not assigned to any Course");
			} else {
				System.out.println("Courses managed by " + tmpTeacher.getTeacherName() + "\n");
				for (String courseName : tempCourses) {
					System.out.println(" * " + courseName);
				}
			}
		}
	}

	/**
	 * This method print all the courses in which one student was enrolled according
	 * with a studentCode given
	 */
	public void printCoursesByStudent(int studentCode) {

		Student tmpStudent = searchStudentCode(studentCode);
		if (tmpStudent == null) {
			System.out.println("Student code doesn't exist - Please review the student code entered");
		} else {
			List<String> tempCourses = searchCoursesByStudent(studentCode);

			if (tempCourses.size() == 0) {
				System.out.println("Student " + tmpStudent.getStudentName() + " is not enrolled in any Course");
			} else {
				System.out.println("Student " + tmpStudent.getStudentName() + " enrolled in:\n");
				for (String courseName : tempCourses) {
					System.out.println(" * " + courseName);

				}
			}

		}
	}

	/**
	 * Search Student Methods
	 **/

	/**
	 * This method shows if one student exist in the list arrayStudent according
	 * with a personalId given
	 */
	public Student searchStudentPersonalId(int personalId) {
		for (Student student : arrayStudent) {
			if (student.getPersonalId() == personalId) {
				return student;
			}
		}
		return null;
	}

	/**
	 * This method shows if one student exist in the list arrayStudent according
	 * with a studentCode given
	 */
	public Student searchStudentCode(int studentCode) {
		for (Student student : arrayStudent) {
			if (student.getStudentCode() == studentCode) {
				return student;
			}
		}
		return null;
	}

	/**
	 * Search Teacher Methods
	 **/

	/**
	 * This method shows if one teacher exist in the list arrayTeacher according
	 * with a personal ID given
	 */
	public Teacher searchTeacherPersonalId(int personalId) {

		for (int i = 0; i < arrayTeacher.size(); i++) {

			if (arrayTeacher.get(i).getPersonalId() == personalId) {
				return arrayTeacher.get(i);
			}
		}
		return null;
	}

	/**
	 * This method shows if one teacher exist in the list arrayTeacher according
	 * with a teacherCode given
	 */
	public Teacher searchTeacherCode(int teacherCode) {
		for (Teacher teacher : arrayTeacher) {
			if (teacher.getTeacherCode() == teacherCode) {
				return teacher;
			}
		}
		return null;
	}

	/**
	 * Search Courses Methods
	 **/

	/**
	 * This method shows if one course exist in the list arrayCourse according with
	 * a courseName given
	 */
	public Course searchCourseByName(String courseName) {

		for (int i = 0; i < arrayCourse.size(); i++) {

			if (arrayCourse.get(i).getCourseName().equals(courseName)) {
				return arrayCourse.get(i);
			}
		}
		return null;
	}

	/**
	 * This method shows if one course exist in the list arrayCourse according with
	 * a courseCode given
	 */
	public Course searchCourseByCode(int courseCode) {
		for (Course course : arrayCourse) {
			if (course.getCourseCode() == courseCode) {
				return course;
			}

		}
		return null;
	}

	/**
	 * This method shows all the courses managed by a Teacher according with a
	 * teacherCode given
	 */
	public List<String> searchCoursesByTeacher(int teacherCode) {

		List<String> arrayCoursesByTeacher;
		arrayCoursesByTeacher = new ArrayList<String>();

		for (Course course : arrayCourse) {
			if (course.getTeacher().getTeacherCode() == teacherCode) {
				arrayCoursesByTeacher.add(course.getCourseName());
			}
		}
		return arrayCoursesByTeacher;
	}

	/**
	 * This method shows all the courses in which an Student was enrolled according
	 * with a studentCode given
	 */
	public List<String> searchCoursesByStudent(int studentCode) {
		List<String> arrayCoursesByStudent;
		arrayCoursesByStudent = new ArrayList<String>();

		for (Course course : arrayCourse) {
			for (Student student : course.getArrayStudentInCourse()) {
				if (student.getStudentCode() == studentCode) {
					arrayCoursesByStudent.add(course.getCourseName());
				}
			}

		}

		return arrayCoursesByStudent;

	}

//	************************************************************************

	public String createStudent(String studentName, int personalId, int age) {

		// Falta añadirlos a los cursos ... hay un metodo que hace eso
		Student student = searchStudentPersonalId(personalId);

		if (student == null) {
			Student newStudent = new Student(studentName, personalId, age);
			arrayStudent.add(newStudent);

			return "Student " + studentName + " enrolled in University";

		} else {

			return "Student" + studentName + " already exist in the University";
		}
	}

	public String createFullTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int experienceYears) {
		Teacher fullTimeTeacher = searchTeacherPersonalId(personalId);
		agreementType = agreementType.toLowerCase();
		if (fullTimeTeacher == null) {
			Teacher newFullTimecher = new FullTimeTeacher(teacherName, personalId, agreementType, baseSalary,
					experienceYears);
			arrayTeacher.add(newFullTimecher);
			return "Teacher " + teacherName + " enrolled in University";
		} else {
			return "Teacher" + teacherName + " already exist in the University";
		}
	}

	public String createParTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int activeHours) {
		Teacher partTimeTeacher = searchTeacherPersonalId(personalId);
		agreementType = agreementType.toLowerCase();
		if (partTimeTeacher == null) {
			Teacher newPartTimecher = new PartTimeTeacher(teacherName, personalId, agreementType, baseSalary,
					activeHours);
			arrayTeacher.add(partTimeTeacher);
			return "Teacher " + teacherName + " enrolled in University";
		} else {
			return "Teacher" + teacherName + " already exist in the University";
		}
	}

	public String createCourse(String courseName, int classroom, Teacher teacher, Student student) {
//
//		courseName = courseName.toLowerCase();
//		Course course = searchCourseByName(courseName);
//
//		if (course == null) {
//
//			Teacher teacher = searchTeacherCode(teacherCode);
//
//			if (teacher == null) {
//				return "Teacher doesn't exist - Please review the teacher code entered";
//			} else {
//				
		Course newCourse = new Course(courseName, classroom, teacher, student);
//				Course newCourse = new Course(courseName, classroom, teacher);
//
		arrayCourse.add(newCourse);
//
		return "Course " + courseName + " added to University";
//			}
//
//		} else {
//			return "Course" + courseName + " already exist in the University";
//		}
//
	}

	/**
	 * Read Methods
	 **/

	/** This method reads numbers inputs */
	public int readNumber(String messsage) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please type " + messsage);
			int option = scan.nextInt();

			return option;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error. Please type a valid option");
			return readNumber(messsage);
		}
	}

	/** This method reads Strings inputs */
	public String readString(String phrase) {
		try {
			Scanner scan = new Scanner(System.in);
			String line;
			System.out.println("Please type " + phrase);
			line = scan.nextLine();
			return line;
		} catch (Exception e) {
			System.out.println("Error reading.");
			return readString(phrase);
		}

	}

	/**
	 * Getters and Setters
	 **/

	public List<Teacher> getArrayTeacher() {
		return arrayTeacher;
	}

	public void setArrayTeacher(List<Teacher> arrayTeacher) {
		this.arrayTeacher = arrayTeacher;
	}

	public List<Student> getArrayStudent() {
		return arrayStudent;
	}

	public void setArrayStudent(List<Student> arrayStudent) {
		this.arrayStudent = arrayStudent;
	}

	public List<Course> getArrayCourse() {
		return arrayCourse;
	}

	public void setArrayCourse(List<Course> arrayCourse) {
		this.arrayCourse = arrayCourse;
	}

}
