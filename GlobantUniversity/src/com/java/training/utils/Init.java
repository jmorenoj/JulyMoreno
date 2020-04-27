package com.java.training.utils;

import java.util.ArrayList;
import java.util.List;

import com.java.training.model.Course;
import com.java.training.model.staff.FullTimeTeacher;
import com.java.training.model.staff.PartTimeTeacher;
import com.java.training.model.staff.Student;
import com.java.training.model.staff.Teacher;

public class Init {

	public static List<Teacher> initTeachers() {

		List<Teacher> arrayTeachers;

		FullTimeTeacher fullTeacher1 = new FullTimeTeacher("Camila Caputo", 1022349906, "full time", 1000000, 1);
		FullTimeTeacher fullTeacher2 = new FullTimeTeacher("Cesar Bayona", 1022349907, "full time", 1000000, 2);
		FullTimeTeacher fullTeacher3 = new FullTimeTeacher("David Ortegon", 1022349908, "full time", 1000000, 3);
		FullTimeTeacher fullTeacher4 = new FullTimeTeacher("Estefania Gomez", 1022349909, "full time", 1000000, 4);
		FullTimeTeacher fullTeacher5 = new FullTimeTeacher("Fernando Collazos", 1022349910, "full time", 1000000, 5);

		PartTimeTeacher partTeacher1 = new PartTimeTeacher("Gonzalo Nieto", 1022349911, "part time", 100000, 10);
		PartTimeTeacher partTeacher2 = new PartTimeTeacher("Guillermo Mugnaini", 1022349912, "part time", 100000, 20);
		PartTimeTeacher partTeacher3 = new PartTimeTeacher("Hugo Garcia", 1022349913, "part time", 100000, 30);
		PartTimeTeacher partTeacher4 = new PartTimeTeacher("Jessica Cardona", 1022349914, "part time", 100000, 40);
		PartTimeTeacher partTeacher5 = new PartTimeTeacher("Jesus Barrios", 1022349915, "part time", 100000, 50);

		arrayTeachers = new ArrayList<Teacher>();
		arrayTeachers.add(fullTeacher1);
		arrayTeachers.add(fullTeacher2);
		arrayTeachers.add(fullTeacher3);
		arrayTeachers.add(fullTeacher4);
		arrayTeachers.add(fullTeacher5);
		arrayTeachers.add(partTeacher1);
		arrayTeachers.add(partTeacher2);
		arrayTeachers.add(partTeacher3);
		arrayTeachers.add(partTeacher4);
		arrayTeachers.add(partTeacher5);

		return arrayTeachers;
	}

	public static List<Student> initStudents() {

		List<Student> arrayStudents;

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

		arrayStudents = new ArrayList<Student>();
		arrayStudents.add(student1);
		arrayStudents.add(student2);
		arrayStudents.add(student3);
		arrayStudents.add(student4);
		arrayStudents.add(student5);
		arrayStudents.add(student6);
		arrayStudents.add(student7);
		arrayStudents.add(student8);
		arrayStudents.add(student9);
		arrayStudents.add(student10);

		return arrayStudents;

	}

	public static List<Course> initCourses(List<Student> arrayStudents, List<Teacher> arrayTeachers) {

		List<Course> arrayCourses;

		/*Static positions */
		Course class1 = new Course("algebra", 101, arrayTeachers.get(0), arrayStudents);
		Course class2 = new Course("arts", 102, arrayTeachers.get(1), arrayStudents.get(0), arrayStudents.get(1), arrayStudents.get(2), arrayStudents.get(3),arrayStudents.get(4));
		Course class3 = new Course("biology", 103, arrayTeachers.get(2), arrayStudents.get(5), arrayStudents.get(6), arrayStudents.get(7), arrayStudents.get(8));
		Course class4 = new Course("english", 104, arrayTeachers.get(3), arrayStudents.get(9), arrayStudents.get(1), arrayStudents.get(2));
		Course class5 = new Course("geometry", 105, arrayTeachers.get(5), arrayStudents);
		Course class6 = new Course("mathematics", 106, arrayTeachers.get(6), arrayStudents.get(3), arrayStudents.get(4));
		Course class7 = new Course("music", 107, arrayTeachers.get(7), arrayStudents.get(5), arrayStudents.get(6), arrayStudents.get(7), arrayStudents.get(8));
		Course class8 = new Course("science", 108, arrayTeachers.get(8), arrayStudents.get(9), arrayStudents.get(1), arrayStudents.get(2), arrayStudents.get(3));		
				
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
