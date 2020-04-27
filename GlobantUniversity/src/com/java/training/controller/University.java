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

import com.java.training.utils.Init;
import com.java.training.model.Course;
import com.java.training.model.staff.FullTimeTeacher;
import com.java.training.model.staff.PartTimeTeacher;
import com.java.training.model.staff.Student;
import com.java.training.model.staff.Teacher;

public class University {
//
	private List<Teacher> arrayTeachers;
	private List<Student> arrayStudents;
	private List<Course> arrayCourses;

	public University() {
		this.arrayTeachers = Init.initTeachers();
		this.arrayStudents = Init.initStudents();
		this.arrayCourses = Init.initCourses(arrayStudents, arrayTeachers);
	}

	/**
	 * Print Methods
	 **/

	/** This method print all teachers in the list arrayTeacher */
	public void printTeachersList() {
		for (int i = 0; i < arrayTeachers.size(); i++) {
			arrayTeachers.get(i).printTeachersList();
		}
	}

	/**
	 * This method print the teacher information according with a teacher code given
	 */
	public void printTeacherByCode(int teacherCode) {
		Teacher temTeacher = searchTeacherCode(teacherCode);
		if (temTeacher == null) {
			System.out.println("Teacher doesn't exist - Please review the teacher code entered");
		} else {
			temTeacher.printTeacher();
		}
	}

	/** This method print all students in the list arrayStudent */
	public void printStudentsList() {
		for (Student student : arrayStudents)
			student.printStudentsList();

	}

	/**
	 * This method print the student information according with a student code given
	 */
	public void printStudentByCode(int studentCode) {
		Student tempStudent = searchStudentCode(studentCode);
		if (tempStudent == null) {
			System.out.println("Student doesn't exist - Please review the student code entered");

		} else {
			tempStudent.printStudent();
		}
	}

	/** This method print all courses in the list arrayCourse */
	public void printCoursesList() {
		for (Course course : arrayCourses) {
			course.printCourseInformation();
		}
	}

	/**
	 * This method print the course information according with a course code given
	 */
	public void printCourseByCode(int courseCode) {
		Course tempCourse = searchCourseByCode(courseCode);
		if (tempCourse == null) {
			System.out.println("Course doesn't exist - Please review the course code entered");
		} else {
			System.out.println(tempCourse);
			System.out.println("\n***** Students List *****\n");
			tempCourse.printAssignedStudent();
		}
	}

	/**
	 * This method print all the courses managed by one teacher according with a
	 * teacher code given
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
	 * with a student code given
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
	 * with a personal ID given
	 */
	public Student searchStudentPersonalId(int personalId) {
		for (Student student : arrayStudents) {
			if (student.getPersonalId() == personalId) {
				return student;
			}
		}
		return null;
	}

	/**
	 * This method shows if one student exist in the list arrayStudent according
	 * with a student code given
	 */
	public Student searchStudentCode(int studentCode) {
		for (Student student : arrayStudents) {
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

		for (int i = 0; i < arrayTeachers.size(); i++) {

			if (arrayTeachers.get(i).getPersonalId() == personalId) {
				return arrayTeachers.get(i);
			}
		}
		return null;
	}

	/**
	 * This method shows if one teacher exist in the list arrayTeacher according
	 * with a teacher code given
	 */
	public Teacher searchTeacherCode(int teacherCode) {
		for (Teacher teacher : arrayTeachers) {
			if (teacher.getTeacherCode() == teacherCode) {
				return teacher;
			}
		}
		return null;
	}

	/**
	 * This method shows if the agreement type is valid to create a teacher
	 **/

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
	 * Search Courses Methods
	 **/

	/**
	 * This method shows if one course exist in the list arrayCourse according with
	 * a course name given
	 */
	public Course searchCourseByName(String courseName) {

		for (int i = 0; i < arrayCourses.size(); i++) {

			if (arrayCourses.get(i).getCourseName().equals(courseName)) {
				return arrayCourses.get(i);
			}
		}
		return null;
	}

	/**
	 * This method shows if one course exist in the list arrayCourse according with
	 * a courseCode given
	 */
	public Course searchCourseByCode(int courseCode) {
		for (Course course : arrayCourses) {
			if (course.getCourseCode() == courseCode) {
				return course;
			}

		}
		return null;
	}

	/**
	 * This method shows all the courses managed by a Teacher according with a
	 * teacher code given
	 */
	public List<String> searchCoursesByTeacher(int teacherCode) {

		List<String> arrayCoursesByTeacher;
		arrayCoursesByTeacher = new ArrayList<String>();

		for (Course course : arrayCourses) {
			if (course.getTeacher().getTeacherCode() == teacherCode) {
				arrayCoursesByTeacher.add(course.getCourseName());
			}
		}
		return arrayCoursesByTeacher;
	}

	/**
	 * This method shows all the courses in which an Student was enrolled according
	 * with a student code given
	 */
	public List<String> searchCoursesByStudent(int studentCode) {
		List<String> arrayCoursesByStudent;
		arrayCoursesByStudent = new ArrayList<String>();

		for (Course course : arrayCourses) {
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
	 * This method create a new Student and enroll it into one existing course
	 */
	public String createStudent(String studentName, int personalId, int age, int courseCode) {

		Student newStudent = new Student(studentName, personalId, age);
		arrayStudents.add(newStudent);
		Course newCourse = searchCourseByCode(courseCode);
		newCourse.addStudentToCourse(newStudent);
		return "\nStudent " + studentName + " enrolled in the University\n" + "Course(s):\n" + " * "
				+ newCourse.getCourseName();

	}

	/**
	 * This method create a new Student and enroll it into several existing courses
	 */
	public String createStudent(String studentName, int personalId, int age, List<Course> arrayCourses) {

		Student newStudent = new Student(studentName, personalId, age);
		arrayStudents.add(newStudent);

		for (Course newCourse : arrayCourses) {
			newCourse.addStudentToCourse(newStudent);
		}

		return "\nStudent " + studentName + " enrolled in the University.\n";
	}

	/**
	 * This method create a new Course and assign one Teacher and one Student to the
	 * course
	 */
	public String createCourse(String courseName, int classroom, Teacher teacher, Student student) {
		Course newCourse = new Course(courseName, classroom, teacher, student);
		arrayCourses.add(newCourse);
		return "\nCourse " + courseName + " added to the University list of courses.";
	}

	/**
	 * This method create a new Course and assign one Teacher and several Student to
	 * the course
	 */
	public String createCourse(String courseName, int classroom, Teacher teacher, List<Student> arrayStudents) {
		Course newCourse = new Course(courseName, classroom, teacher, arrayStudents);
		arrayCourses.add(newCourse);
		return "\nCourse " + courseName + " added to courses Database.";
	}

	/**
	 * This method shows the result after create a new Teacher and enroll the
	 * teacher to a existing course
	 */
	public String createTeacher(int personalId, String teacherName, int baseSalary, String agreementType) {
		String result;
		if (agreementType.equals("full time")) {
			int experienceYears = this.readNumber("the teacher experience years");
			result = this.createFullTimeTeacher(teacherName, personalId, agreementType, baseSalary, experienceYears);
		} else {
			int activeHours = this.readNumber("the active hours per month");
			result = this.createPartTimeTeacher(teacherName, personalId, agreementType, baseSalary, activeHours);
		}
		Course course = this.askForCourse();
		course.setTeacher(this.searchTeacherPersonalId(personalId));
		return result;
	}

	/** This method create a Full Time Teacher */
	public String createFullTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int experienceYears) {
		Teacher newFullTimeTeacher = new FullTimeTeacher(teacherName, personalId, agreementType, baseSalary,
				experienceYears);
		arrayTeachers.add(newFullTimeTeacher);
		return "Full Time Teacher " + teacherName + " enrolled in the University.";
	}

	/** This method create a Part Time Teacher */
	public String createPartTimeTeacher(String teacherName, int personalId, String agreementType, double baseSalary,
			int activeHours) {
		Teacher newPartTimeTeacher = new PartTimeTeacher(teacherName, personalId, agreementType, baseSalary,
				activeHours);
		arrayTeachers.add(newPartTimeTeacher);
		return "Part Time Teacher " + teacherName + " enrolled in the University.";
	}

	/**
	 * Read Methods
	 **/

	/** This method reads numbers inputs */
	public int readNumber(String messsage) {
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Please type " + messsage);
			int option = scan.nextInt();
//			System.out.println("Closing Scanner...");
			return option;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error reading - Please type a valid option.\n");
			return readNumber(messsage);
		}
	}

	/** This method reads Strings inputs */
	public String readString(String phrase) {
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String line;
			System.out.println("Please type " + phrase);
			line = scan.nextLine();
			return line;
		} catch (Exception e) {
			System.out.println("Error reading - Please type a valid option.\n");
			return readString(phrase);
		}

	}

	/**
	 * Validation Methods
	 **/

	/** This method validate if a Student code exist in Students List */
	public Student askForStudent() {

		System.out.println("\n    Students to enroll:\n");
		this.printStudentsList();
		System.out.println("\n");
		int studentCode = this.readNumber("the student code to enroll");
		Student student = this.searchStudentCode(studentCode);
		if (student == null) {
			System.out.println("\nStudent doesn't exist - Please review the student code entered.");
			student = this.askForStudent();
		}
		return student;
	}

	/**
	 * This method allows to validate several student codes when a course is being
	 * created
	 */
	public ArrayList<Student> askForStudents() {

		int studentCode;
		Student student = this.askForStudent();

		ArrayList<Student> arrayListStudent = new ArrayList<Student>();
		arrayListStudent.add(student);

		do {
			studentCode = this.readNumber("a new student code to add or 0 to continue ");
			if (studentCode != 0) {
				student = this.searchStudentCode(studentCode);
				if (student == null) {
					System.out.println("\nStudent doesn't exist - Please review the student code entered.");
				} else {
					arrayListStudent.add(student);
				}
			}
		} while (studentCode != 0);
		return arrayListStudent;
	}

	/** This method validate if a personal ID already exist in the Students List */
	public int askForStudentId() {
		int personalId = this.readNumber("the student personal ID");
		Student student = this.searchStudentPersonalId(personalId);
		if (student == null) {
			return personalId;
		}
		System.out.println("Personal Id " + personalId + " " + student.getStudentName()
				+ " already exist in Students Database.\n");
		return this.askForStudentId();
	}

	/** This method validate if a Teacher code exist in Teachers List */
	public Teacher askForTeacher() {

		System.out.println("\n    Assign teacher:\n");
		this.printTeachersList();
		System.out.println("\n");

		int teacherCode = this.readNumber("the teacher code to assign");
		Teacher teacher = this.searchTeacherCode(teacherCode);

		if (teacher == null) {
			System.out.println("\nTeacher doesn't exist - Please review the teacher code entered.");
			teacher = this.askForTeacher();
		}
		return teacher;
	}

	/** This method validate if a Teacher personal ID exist in Teachers List */
	public int askForTeacherId() {
		int personalId = this.readNumber("the teacher personal ID");
		Teacher teacher = this.searchTeacherPersonalId(personalId);
		if (teacher == null) {
			return personalId;
		}
		System.out.println("Personal Id " + personalId + " " + teacher.getTeacherName()
				+ " already exist in Teachers Database.\n");
		return this.askForTeacherId();
	}

	/** This method validate if a Agreement type exist in Agreements List */
	public String askForAgreementType() {
		String agreementType = this.readString("the agreement type (full time / part time)");
		agreementType = searchAgreementType(agreementType);
		if (agreementType == null) {
			System.out.println("\nAgreement type doesn't exist - Please review the agreement type entered.\n");
			agreementType = this.askForAgreementType();
		}
		return agreementType;
	}

	/**
	 * This method validate if a Course code exist in Courses List to assign it to
	 * student or teacher
	 */
	public Course askForCourse() {
		System.out.println("\n***** Courses availables to enroll *****\n");
		this.printCoursesList();
		System.out.println("\n");
		int courseCode = this.readNumber("the course code to enroll: ");
		Course course = this.searchCourseByCode(courseCode);
		if (course == null) {
			System.out.println("\nCourse code doesn't exist - Please review the course code entered.");
			course = this.askForCourse();
		}
		return course;
	}

	/**
	 * This method allows to validate several course codes when a student is being
	 * created
	 */
	public ArrayList<Course> askForCourses() {

		int courseCode;
		Course course = this.askForCourse();
		ArrayList<Course> arrayListCourse = new ArrayList<Course>();
		arrayListCourse.add(course);

		do {
			courseCode = this.readNumber("a new course code to assign or 0 to continue.");
			if (courseCode != 0) {
				course = this.searchCourseByCode(courseCode);
				if (course == null) {
					System.out.println("\nCourse code doesn't exist - Please review the course code entered.");
				} else {
					arrayListCourse.add(course);
				}
			}
		} while (courseCode != 0);
		return arrayListCourse;
	}

	/** This method validate if a Course already exist in Courses List */
	public String askForNullCourse() {
		Course course;
		String courseName;
		courseName = this.readString("the course name").toLowerCase();
		course = this.searchCourseByName(courseName);
		if (course != null) {
			System.out.println("Course already exist.\n");
			courseName = this.askForNullCourse();
		}
		return courseName;
	}

	/**
	 * Getters and Setters
	 **/

	public List<Teacher> getArrayTeachers() {
		return arrayTeachers;
	}

	private void setArrayTeachers(List<Teacher> arrayTeachers) {
		this.arrayTeachers = arrayTeachers;
	}

	public List<Student> getArrayStudents() {
		return arrayStudents;
	}

	private void setArrayStudents(List<Student> arrayStudents) {
		this.arrayStudents = arrayStudents;
	}

	public List<Course> getArrayCourses() {
		return arrayCourses;
	}

	private void setArrayCourses(List<Course> arrayCourses) {
		this.arrayCourses = arrayCourses;
	}

}
