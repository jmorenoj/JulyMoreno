package com.java.training.view;

import java.util.ArrayList;

import com.java.training.controller.University;
import com.java.training.model.Course;
import com.java.training.model.staff.Student;
import com.java.training.model.staff.Teacher;
//comment test

public class Menu {

	public static University globant = new University();

	public static void main(String[] args) {

		int option;
		int baseSalary;
		int classroom;
		int courseCode;
		int personalId;
		int studentAge;
		int studentCode;
		int teacherCode;
		String agreementType;
		String courseName;
		String createTeacherResult;
		String studentName;
		String teacherName;


		while (true) {
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("     *************** GLOBANT UNIVERSITY® ***************    ");
			System.out.println("1. Print Teachers List\n" + "2. Print one teacher information\n"
					+ "3. Print Students List\n" + "4. Print one Student information\n" + "5. Print Courses List\n"
					+ "6. Print one Course information\n" + "7. Print Courses by Teacher\n"
					+ "8. Print Courses by Student\n" + "9. Create a Course\n" + "10. Create a Student\n"
					+ "11. Create a Teacher\n" + "12. Exit");

			System.out.println("---------------------------------------------------------------\n");

			option = globant.readNumber("an option:");
			switch (option) {

			case 1: { /* Print all Teachers List */

				System.out.println(
						"---------------------------------------------  Teachers List  -------------------------------------------------------");
				globant.printTeachersList();
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 2: { /* Print One Teacher information */

				teacherCode = globant.readNumber("the teacher code");
				System.out.println(
						"---------------------------------------------  Teacher Information  -------------------------------------------------");

				globant.printTeacherByCode(teacherCode);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 3: { /* Print all Students List */

				System.out.println(
						"---------------------------------------------  Students List  -------------------------------------------------------");
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

			case 5: { /* Print all Courses List */

				System.out.println(
						"----------------------------------------------- Courses List --------------------------------------------------------");
				globant.printCoursesList();
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
				do {
					courseCode = globant.readNumber("the course code to see the course details or 0 to return to the menu");
					if(courseCode != 0) {
					System.out.println(
							"-----------------------------------------------  Course Information  --------------------------------------------");
					globant.printCourseByCode(courseCode);
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------");
					}
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
						"----------------------------------------------- Courses List by Teacher ----------------------------------------------");
				globant.printCoursesByTeacher(teacherCode);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				break;
			}

			case 8: { /* Print Courses by Student */

				studentCode = globant.readNumber("the student code");
				System.out.println(
						"----------------------------------------------  Courses List by Student  ---------------------------------------------");
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
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
				
				break;
			}

			case 10: { /* Create Student */

				personalId = globant.askForStudentId();
				studentName = globant.readString("the student name");
				studentAge = globant.readNumber("the student age");
				ArrayList<Course> arrayListCourse = globant.askForCourses();
				System.out.println(globant.createStudent(studentName, personalId, studentAge, arrayListCourse));
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
				
				break;
			}

			case 11: { /* Create Teacher */

				personalId = globant.askForTeacherId();
				teacherName = globant.readString("the teacher name");
				baseSalary = globant.readNumber("the base salary");
				agreementType = globant.askForAgreementType();
				createTeacherResult = globant.createTeacher(personalId,teacherName,baseSalary,agreementType);
				System.out.println("\n" + createTeacherResult);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
				
				break;
				
			}

			case 12: { /* Logout */
				System.out.println("Session ended.");
				System.exit(0);
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
				
				break;
			}

			default: /* Error */
				System.out.println("\n" + "Option is not in the menu." + "\n");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");
			}
		}
	}

}
