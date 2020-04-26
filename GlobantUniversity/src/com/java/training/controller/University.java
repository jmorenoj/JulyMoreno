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
import com.java.training.utils.Init;
import com.java.training.model.Course;

public class University {

	private List<Teacher> arrayTeacher;
	private List<Student> arrayStudent;
	private List<Course> arrayCourse;

	public University() {
		this.arrayTeacher = Init.initTeacher();
		this.arrayStudent = Init.initStudents();
		this.arrayCourse = Init.initCourses(arrayStudent, arrayTeacher);
	}

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

	public String searchAgreementType(String agreementType) {

		List<String> arrayAgreementType = new ArrayList<String>();
		arrayAgreementType.add("full time");
		arrayAgreementType.add("part time");

		for (String agreement : arrayAgreementType) {
			if (agreement.equals(agreementType)) {
				return agreementType;
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

	/**
	 * Creation methods
	 */

	/**
	 * This method create a new Student and enroll the student to a existing course
	 */
	public String createStudent(String studentName, int personalId, int age, int courseCode) {

		Student newStudent = new Student(studentName, personalId, age);
		arrayStudent.add(newStudent);
		Course newCourse = searchCourseByCode(courseCode);
		newCourse.addStudentToCourse(newStudent);
		return "\nStudent " + studentName + " enrolled in the University\n" + "Course(s):\n"
				+ newCourse.getCourseName();

	}

	public String createStudent(String studentName, int personalId, int age, List<Course> arrayCourses) {

		Student newStudent = new Student(studentName, personalId, age);
		arrayStudent.add(newStudent);

		for (Course newCourse : arrayCourses) {
			newCourse.addStudentToCourse();
		}

		return "\nStudent " + studentName + " enrolled in the University\n";
	}

	/**
	 * This method create a new Course and assign one Teacher and Student to the
	 * class
	 */
	public String createCourse(String courseName, int classroom, Teacher teacher, Student student) {
		Course newCourse = new Course(courseName, classroom, teacher, student);
		arrayCourse.add(newCourse);
		return "\nCourse " + courseName + " added to University";
	}

	public String createCourse(String courseName, int classroom, Teacher teacher, List<Student> arrayStudents) {
		Course newCourse = new Course(courseName, classroom, teacher, arrayStudents);
		arrayCourse.add(newCourse);
		return "\nCourse " + courseName + " added to University";
	}

	/** This method create a new Full Time Teacher and assign it to a class */
	public String createFullTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int experienceYears) {
		Teacher newFullTimeTeacher = new FullTimeTeacher(teacherName, personalId, agreementType, baseSalary,
				experienceYears);
		arrayTeacher.add(newFullTimeTeacher);
		return "Full Time Teacher " + teacherName + " enrolled in the University";
	}

	/** This method create a new Part Time Teacher and assign it to a class */
	public String createParTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int activeHours) {
		Teacher newPartTimeTeacher = new PartTimeTeacher(teacherName, personalId, agreementType, baseSalary,
				activeHours);
		arrayTeacher.add(newPartTimeTeacher);
		return "Part Time Teacher " + teacherName + " enrolled in the University";
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
	 * Validation Methods
	 **/

	/** This method validate if a Course already exist in Courses List */
	public String askForNullCourse() {
		Course course;
		String courseName;
		courseName = this.readString("the course name").toLowerCase();
		course = this.searchCourseByName(courseName);
		if (course != null) {
			System.out.println("Course already exist\n");
			courseName = this.askForNullCourse();
		}
		return courseName;
	}

	/** This method validate if a Teacher code exist in Teachers List */
	public Teacher askForTeacher() {

		System.out.println("\n    Assign teacher:\n");
		this.printTeachersList();
		System.out.println("\n");

		int teacherCode = this.readNumber("the teacher code to assign");
		Teacher teacher = this.searchTeacherCode(teacherCode);

		if (teacher == null) {
			System.out.println("\nTeacher doesn't exist - Please review the teacher code entered");
			teacher = this.askForTeacher();
		}
		return teacher;
	}

	/** This method validate if a Student code exist in Students List */
	public Student askForStudent() {

		System.out.println("\n    Students to enroll:\n");
		this.printStudentsList();
		System.out.println("\n");
		int studentCode = this.readNumber("the student code to enroll");
		Student student = this.searchStudentCode(studentCode);
		if (student == null) {
			System.out.println("\nStudent doesn't exist - Please review the student code entered");
			student = this.askForStudent();
		}
		return student;
	}

	public ArrayList<Student> askForStudents() {

		int studentCode;

		Student student = this.askForStudent();

		ArrayList<Student> arrayListStudent = new ArrayList<Student>();
		arrayListStudent.add(student);

		do {
			studentCode = this.readNumber("a new student code to add or 0 for exit ");
			if (studentCode != 0) {
				student = this.searchStudentCode(studentCode);
				if (student == null) {
					System.out.println("\nStudent doesn't exist - Please review the student code entered");
				} else {
					arrayListStudent.add(student);
				}
			}
		} while (studentCode != 0);
		return arrayListStudent;
	}

	/** This method validate if a Teacher personal ID exist in Teachers List */
	public int askForStudentId() {
		int personalId = this.readNumber("the student personal ID");
		Student student = this.searchStudentPersonalId(personalId);
		if (student == null) {
			return personalId;
		}
		System.out.println(
				"Personal Id " + personalId + " " + student.getStudentName() + " already exist in the university\n");
		return this.askForStudentId();
	}

	/** This method validate if a Student personal ID exist in Students List */
	public int askForTeacherId() {
		int personalId = this.readNumber("the teacher personal ID");
		Teacher teacher = this.searchTeacherPersonalId(personalId);
		if (teacher == null) {
			return personalId;
		}
		System.out.println(
				"Personal Id " + personalId + " " + teacher.getTeacherName() + " already exist in the university\n");
		return this.askForTeacherId();
	}

	/** This method validate if a Course code exist in Courses List */
	public Course askForCourse() {
		System.out.println("\n    Courses availables to enroll:\n");
		this.printCoursesList();
		System.out.println("\n");
		int courseCode = this.readNumber("the course code to enroll: ");
		Course course = this.searchCourseByCode(courseCode);
		if (course == null) {
			System.out.println("\nCourse doesn't exist - Please review the course code entered");
			course = this.askForCourse();
		}
		return course;
	}

	public ArrayList<Course> askForCourses() {

		int courseCode;
		Course course = this.askForCourse();
		ArrayList<Course> arrayListCourse = new ArrayList<Course>();
		arrayListCourse.add(course);

		do {
			courseCode = this.readNumber("a new course code to add or 0 for exit ");
			if (courseCode != 0) {
				course = this.searchCourseByCode(courseCode);
				if (course == null) {
					System.out.println("\nCourse doesn't exist - Please review the course code entered");
				} else {
					arrayListCourse.add(course);
				}
			}
		} while (courseCode != 0);
		return arrayListCourse;
	}

	/** This method validate if a Agreement type exist in Agreements List */
	public String askForAgreementType() {
		String agreementType = this.readString("the agreement type (full time / part time)");
		agreementType = searchAgreementType(agreementType);
		if (agreementType == null) {
			System.out.println("\nAgreement type doesn't exist - Please review the agreement type entered\n");
			agreementType = this.askForAgreementType();
		}
		return agreementType;
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

	public String askForNullCourse() {
		Course course;
		String courseName;
		courseName = this.readString("the course name").toLowerCase();
		course = this.searchCourseByName(courseName);
		if (course != null) {
			System.out.println("Course already exits.");
			courseName= this.askForNullCourse();
		}
		return courseName;
	}

	public Teacher askForTeacher() {
		
		System.out.println("\n    Assign teacher:\n");
		this.printTeachersList();
		System.out.println("\n");

		int teacherCode = this.readNumber("the teacher code to assign");
		Teacher teacher = this.searchTeacherCode(teacherCode);

		if (teacher == null) {
			System.out.println("\nTeacher doesn't exist - Please review the teacher code entered");
			teacher=this.askForTeacher();
		}
		return teacher;
	}

	public Student askForStudent() {

		System.out.println("\n    Students to enroll:\n");
		this.printStudentsList();
		System.out.println("\n");
		int studentCode = this.readNumber("the student code to enroll");
		Student student = this.searchStudentCode(studentCode);
		if (student == null) {
			System.out.println("\nStudent doesn't exist - Please review the student code entered");
			student= this.askForStudent();
		} 
		return student;
	}

}
