package com.java.training.utils;

import java.util.ArrayList;
import java.util.List;

import com.java.training.model.Course;
import com.java.training.model.FullTimeTeacher;
import com.java.training.model.PartTimeTeacher;
import com.java.training.model.Student;
import com.java.training.model.Teacher;

public class Init {

	public static List<Teacher> initTeacher() {

		List<Teacher> arrayTeacher;

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

		arrayTeacher = new ArrayList<Teacher>();
		arrayTeacher.add(fullTeacher1);
		arrayTeacher.add(fullTeacher2);
		arrayTeacher.add(fullTeacher3);
		arrayTeacher.add(fullTeacher4);
		arrayTeacher.add(fullTeacher5);
		arrayTeacher.add(partTeacher1);
		arrayTeacher.add(partTeacher2);
		arrayTeacher.add(partTeacher3);
		arrayTeacher.add(partTeacher4);
		arrayTeacher.add(partTeacher5);

		return arrayTeacher;
	}

	public static List<Student> initStudents() {

		List<Student> arrayStudent;

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

		arrayStudent = new ArrayList<Student>();
		arrayStudent.add(student1);
		arrayStudent.add(student2);
		arrayStudent.add(student3);
		arrayStudent.add(student4);
		arrayStudent.add(student5);
		arrayStudent.add(student6);
		arrayStudent.add(student7);
		arrayStudent.add(student8);
		arrayStudent.add(student9);
		arrayStudent.add(student10);

		return arrayStudent;

	}

	public static List<Course> initCourses(List<Student> arrayStudent, List<Teacher> arrayTeacher) {

		List<Course> arrayCourse;

		/*Static positions */
		Course class1 = new Course("algebra", 101, arrayTeacher.get(0), arrayStudent.get(9), arrayStudent.get(1), arrayStudent.get(2), arrayStudent.get(5),arrayStudent.get(0));
		Course class2 = new Course("mathematics", 102, arrayTeacher.get(1), arrayStudent.get(3), arrayStudent.get(4), arrayStudent.get(5));
		Course class3 = new Course("geometry", 103, arrayTeacher.get(2), arrayStudent.get(6), arrayStudent.get(7), arrayStudent.get(8));
		Course class4 = new Course("biology", 104, arrayTeacher.get(5), arrayStudent.get(9), arrayStudent.get(0), arrayStudent.get(8));
		Course class5 = new Course("music", 105, arrayTeacher.get(6), arrayStudent.get(1), arrayStudent.get(2), arrayStudent.get(6), arrayStudent.get(7));
		Course class6 = new Course("science", 106, arrayTeacher.get(7), arrayStudent);
		Course class7 = new Course("art", 107, arrayTeacher.get(8), arrayStudent);
		
		arrayCourse = new ArrayList<Course>();
		arrayCourse.add(class1);
		arrayCourse.add(class2);
		arrayCourse.add(class3);
		arrayCourse.add(class4);
		arrayCourse.add(class5);
		arrayCourse.add(class6);
		arrayCourse.add(class7);

		return arrayCourse;
	}

}
