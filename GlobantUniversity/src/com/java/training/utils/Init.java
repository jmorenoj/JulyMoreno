package com.java.training.utils;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;

import com.java.training.model.Course;
import com.java.training.model.staff.FullTimeTeacher;
import com.java.training.model.staff.PartTimeTeacher;
import com.java.training.model.staff.Student;
import com.java.training.model.staff.Teacher;

public class Init {

	public static List<Teacher> initTeachers() {

		List<Teacher> arrayTeachers = new ArrayList<Teacher>();

		try {

			File file = new File("src/com/java/training/utils/Teachers.dat");
			Scanner myReader = new Scanner(file);
			Teacher teacher;
			while (myReader.hasNextLine()) {
				String[] data = myReader.nextLine().split(",");
				if (data[2].equals("full time")) {
					teacher = new FullTimeTeacher(data[0], Integer.parseInt(data[1]), data[2],
							Double.parseDouble(data[3]), Integer.parseInt(data[4]));
				} else {
					teacher = new PartTimeTeacher(data[0], Integer.parseInt(data[1]), data[2],
							Double.parseDouble(data[3]), Integer.parseInt(data[4]));
				}
				arrayTeachers.add(teacher);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred reading teachers file.");
			e.printStackTrace();
		}
		return arrayTeachers;
	}

	public static List<Student> initStudents() {

		List<Student> arrayStudents = new ArrayList<Student>();
		try {
			File file = new File("src/com/java/training/utils/Students.dat");
			Scanner myReader = new Scanner(file);
			Student student;
			while (myReader.hasNextLine()) {
				String[] data = myReader.nextLine().split(",");
				student = new Student(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
				arrayStudents.add(student);
			}
			myReader.close();
		} catch (Exception e) {
			System.out.println("An error occurred reading students file.");
			e.printStackTrace();
		}
		return arrayStudents;
	}

	public static void saveStudent(Student student) {
		
		try {
			FileWriter file = new FileWriter("src/com/java/training/utils/Students.dat",true);
			file.write("\n"+student.getStudentName()+","+student.getPersonalId()+","+student.getAge()+",");
			file.close();
		} catch (Exception e) {
			System.out.println("An error occurred writing students file.");
			e.printStackTrace();
		}

	}
	

	public static void saveTeacher(Teacher teacher) {
		
		try {
			FileWriter file = new FileWriter("src/com/java/training/utils/Teachers.dat",true);
			if (teacher.getAgreementType().equals("full time")) {
				file.write("\n"+teacher.getTeacherName()+","+teacher.getPersonalId()+","+teacher.getAgreementType()+","+(int) teacher.getBaseSalary()+","+teacher.getExperienceYears()+",");			
				} 
			else {		
				file.write("\n"+teacher.getTeacherName()+","+teacher.getPersonalId()+","+teacher.getAgreementType()+","+(int) teacher.getBaseSalary()+","+teacher.getActiveHours()+",");
			}
			file.close();
		} catch (Exception e) {
			System.out.println("An error occurred writing students file.");
			e.printStackTrace();
		}

	}

	public static List<Course> initCourses(List<Student> arrayStudents, List<Teacher> arrayTeachers) {

		List<Course> arrayCourses;

		/* Static positions */
		Course class1 = new Course("algebra", 101, arrayTeachers.get(0), arrayStudents);
		Course class2 = new Course("arts", 102, arrayTeachers.get(1), arrayStudents.get(0), arrayStudents.get(1),
				arrayStudents.get(2), arrayStudents.get(3), arrayStudents.get(4));
		Course class3 = new Course("biology", 103, arrayTeachers.get(2), arrayStudents.get(5), arrayStudents.get(6),
				arrayStudents.get(7), arrayStudents.get(8));
		Course class4 = new Course("english", 104, arrayTeachers.get(3), arrayStudents.get(9), arrayStudents.get(1),
				arrayStudents.get(2));
		Course class5 = new Course("geometry", 105, arrayTeachers.get(5), arrayStudents);
		Course class6 = new Course("mathematics", 106, arrayTeachers.get(6), arrayStudents.get(3),
				arrayStudents.get(4));
		Course class7 = new Course("music", 107, arrayTeachers.get(7), arrayStudents.get(5), arrayStudents.get(6),
				arrayStudents.get(7), arrayStudents.get(8));
		Course class8 = new Course("science", 108, arrayTeachers.get(8), arrayStudents.get(9), arrayStudents.get(1),
				arrayStudents.get(2), arrayStudents.get(3));

		arrayCourses = new ArrayList<Course>();
		arrayCourses.add(class1);
		arrayCourses.add(class2);
		arrayCourses.add(class3);
		arrayCourses.add(class4);
		arrayCourses.add(class5);
		arrayCourses.add(class6);
		arrayCourses.add(class7);
		arrayCourses.add(class8);
		return arrayCourses;
	}

}
