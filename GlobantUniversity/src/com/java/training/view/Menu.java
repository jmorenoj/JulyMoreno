package com.java.training.view;

import java.util.ArrayList;

import com.java.training.controller.University;
import com.java.training.model.Course;
import com.java.training.model.FullTimeTeacher;
import com.java.training.model.Student;
import com.java.training.model.Teacher;

public class Menu {

	public static University globant = new University();

	public static void main(String[] args) {

		int option;
		int classroom;
		int studentAge;
		String courseName;
		String teacherName;
		String studentName;
		String agreementType;
		int baseSalary;
		int activeHours;
		int experienceYears;
		int personalId;
		int studentCode;
		int teacherCode;
		int courseCode;

		while (true) {
			System.out.println("\n-------------------------------------------------");
			System.out.println("  *************** GLOBANT UNIVERSITY® ***************  ");
			System.out.println("1. Print Teachers List\n" + "2. Print Teacher information\n"
					+ "3. Print Students List\n" + "4. Print Student information\n" + "5. Print Courses List\n"
					+ "6. Print Courses information\n" + "7. Print Courses by Teacher\n"
					+ "8. Print Courses by Student\n" + "9. Create Course\n" + "10. Create Student\n"
					+ "11. Create Teacher\n" + "12. Exit");

			System.out.println("-------------------------------------------------\n");

			option = globant.readNumber("an option: ");

			switch (option) {

			case 1: { /* Print Teachers List */

				System.out.println(
						"---------------------------------------------  Teachers List  -------------------------------------------------------");
				globant.printTeachersList();
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 2: { /* Print One Teacher's information */

				teacherCode = globant.readNumber("the teacher code");
				System.out.println(
						"---------------------------------------------  Teacher Information  -------------------------------------------------");

				globant.printTeacherByCode(teacherCode);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 3: { /* Print Students List */

				System.out.println(
						"---------------------------------------------  StudentS List  -------------------------------------------------------");
				globant.printStudentsList();
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
				break;
			}

			case 4: { /* Print one Student information */

				studentCode = globant.readNumber("the student code");
				System.out.println(
						"---------------------------------------------  Student Information  -------------------------------------------------");
				globant.printStudentByCode(studentCode);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 5: { /* Print Courses List */

				System.out.println(
						"----------------------------------------------- Courses List --------------------------------------------------------");
				globant.printCoursesList();
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
				do {
					courseCode = globant.readNumber("the course code or 0 to return the menu");
					System.out.println(
							"-----------------------------------------------  Course Information  ------------------------------------------------");
					globant.printCourseByCode(courseCode);
					System.out.println(
							"---------------------------------------------------------------------------------------------------------------------");

				} while (courseCode != 0);

				break;
			}

			case 6: { /* Print one Course information */

				courseCode = globant.readNumber("the course code");
				System.out.println(
						"-----------------------------------------------  Course Information  ------------------------------------------------");
				globant.printCourseByCode(courseCode);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 7: { /* Print Courses by Teacher */

				teacherCode = globant.readNumber("the teacher code");
				System.out.println(
						"----------------------------------------------- Course List by Teacher ----------------------------------------------");
				globant.printCoursesByTeacher(teacherCode);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 8: { /* Print Courses by Student */

				studentCode = globant.readNumber("the University student code");
				System.out.println(
						"----------------------------------------------  Course List by Student  ---------------------------------------------");
				globant.printCoursesByStudent(studentCode);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 9: { /* Create Course */

				courseName = globant.askForNullCourse();
				classroom = globant.readNumber("the classroom assigned");
				Teacher teacher = globant.askForTeacher();
				ArrayList<Student> arrayListStudent = globant.askForStudents();
				System.out.println(globant.createCourse(courseName, classroom, teacher, arrayListStudent));

				break;
			}

			case 10: { /* Create Student */

				personalId = globant.askForStudentId();
				studentName = globant.readString("the student name");
				studentAge = globant.readNumber("the student age");
				ArrayList<Course> arrayListCourse = globant.askForCourses();

				System.out.println(globant.createStudent(studentName, personalId, studentAge, arrayListCourse));

				break;
			}

			case 11: { /* Create Teacher */

				String result;
				personalId = globant.askForTeacherId();
				teacherName = globant.readString("the teacher name");
				baseSalary = globant.readNumber("the base salary");
				agreementType = globant.askForAgreementType();
				if (agreementType.equals("full time")) {
					experienceYears = globant.readNumber("the teacher experience years");
					result = globant.createFullTimeTeacher(teacherName, personalId, agreementType, baseSalary,
							experienceYears);
				} else {
					activeHours = globant.readNumber("the active hours per month");
					result = globant.createParTimeTeacher(teacherName, personalId, agreementType, baseSalary,
							activeHours);
				}
				Course course = globant.askForCourse();
				course.setTeacher(globant.searchTeacherPersonalId(personalId));

				System.out.println("\n" + result);

				break;
			}

			case 12: { /* Logout */
				System.out.println("Session ended");
				System.exit(0);
				break;
			}

			default: /* Error */
				System.out.println("\n" + "Option is not in the menu" + "\n");
			}
		}
	}

}