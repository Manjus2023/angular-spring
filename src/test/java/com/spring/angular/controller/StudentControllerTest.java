package com.spring.angular.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.angular.dao.StudentDAO;
import com.spring.angular.model.Student;
import com.spring.angular.util.BootStrapStudent;

@SpringBootTest
@AutoConfigureMockMvc
@Import(Student.class)
class StudentControllerTest {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	StudentController studentController;
	
	static Student student = new Student();
	static List<Student> students = new ArrayList<>();
	
	
	BootStrapStudent bootStrapStudent;
	
	static boolean setUpDone = false;
	
	@BeforeEach
	public void setUp() {
		if (setUpDone) {
			return;
		}
		this.bootStrapStudent = new BootStrapStudent(studentDAO, student, students);
		StudentControllerTest.students = bootStrapStudent.createStudents();
		StudentControllerTest.student = bootStrapStudent.getStudent();
		setUpDone = true;
	}
	
	@Test
	
	void testGetAllStudentsList() throws Exception {
		
		
		mockMvc.perform(get("/api/students-list"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value("2"));

		
		
	}

	@Test
	void testGetStudentById() throws Exception {
		
		mockMvc.perform(get("/api/student/{id}", StudentControllerTest.student.getStudent_id()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.student_id").value(StudentControllerTest.student.getStudent_id()));
		
	}

	@Test
	void testSaveStudent() throws Exception {
		
		mockMvc.perform(get("/api/save-student", bootStrapStudent.getStudent()));
		
				
	}

	@Test
	void testDeleteStudent() {
		
	}

	@Test
	void testUpdateStudent() {
		
	}

}
