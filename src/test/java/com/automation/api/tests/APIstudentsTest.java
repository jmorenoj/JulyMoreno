package com.automation.api.tests;

import com.automation.api.data.Data;
import com.automation.api.pojo.Student;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.api.steps.Students;

public class APIstudentsTest {

	private Students steps;

	@BeforeMethod
	@Parameters({ "uri" })
	public void test(String uri) {
		steps = new Students(uri);
	}

	@Test(description = "Get the list of students", enabled = false)
	public void getStudentsTest() {
		steps.getStudentsAPIEndpoint();
		steps.getStudents();
		steps.isStatusCode(200);
		steps.showActualStudentsList();
	}

	@Test(description = "Get an specific student", enabled = false)
	@Parameters({ "name", "email" })
	public void getUserTest(String name, String email) {
		steps.getStudentsAPIEndpoint();
		steps.getStudents();
		steps.isStatusCode(200);
		Student student = steps.getStudentId(name);
		Assert.assertNotEquals(student, "", "User doesn't exists");
		steps.getStudent(student.getId());
		steps.isStatusCode(200);
		steps.userEmailShouldBe(email);
	}

	@Test(description = "Update student final note", dataProviderClass = Data.class, dataProvider = "myStudent", enabled = false)
	public void putFinalNoteTest(Student student) {
		steps.getStudentsAPIEndpoint();
		steps.getStudents();
		steps.isStatusCode(200);
		Student tmpStudent = steps.getStudentId(student.getFirst_name() + " " + student.getLast_name());
		Assert.assertNotEquals(tmpStudent, "", "User doesn't exists");
		steps.getStudentsAPIEndpoint();
		steps.updateStudentFinalNote(tmpStudent.getId(), 1.6);
		steps.isStatusCode(200);
//		steps.finalNoteChanged(1.6);
	}

	@Test(description = "Update student approved status", dataProviderClass = Data.class, dataProvider = "myStudent", enabled = true)
	public void putApprovedStatusTest(Student student) {
		steps.getStudentsAPIEndpoint();
		steps.getStudents();
		steps.isStatusCode(200);
		Student tmpStudent = steps.getStudentId(student.getFirst_name() + " " + student.getLast_name());
		Assert.assertNotEquals(tmpStudent, "", "User doesn't exists");
		steps.getStudentsAPIEndpoint();
		steps.updateStudentApprovedStatus(tmpStudent.getId(), false);
		steps.isStatusCode(200);
		steps.finalApprovedStatus(false);
		steps.getStudent(tmpStudent.getId());
	}

}
