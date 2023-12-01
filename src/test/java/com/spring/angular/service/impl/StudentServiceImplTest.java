package com.spring.angular.service.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.spring.angular.dao.StudentDAO;
import com.spring.angular.model.Student;
import com.spring.angular.util.BootStrapStudent;



@DataJpaTest
class StudentServiceImplTest {
	
	@Autowired
	StudentDAO studentDAO;
	
	BootStrapStudent bootStrapStudent;
	
	Student student;
	List<Student> students = new ArrayList<>();
	
	
	@BeforeEach
	public void setUp() {
		this.bootStrapStudent = new BootStrapStudent(studentDAO, student, students);
	}

	@Test
	@Transactional
	@Rollback
	void testSaveStudent() {
		Student newStudent = bootStrapStudent.getStudent();
		
		assertEquals(this.studentDAO.findById(newStudent.getStudent_id()).get().getStudent_branch(), newStudent.getStudent_branch());
		Assertions.assertThat(newStudent.getStudent_id() > 0);
	}
	
	

	

	@Test
	@Transactional
	@Rollback
	void testGetStudents() {

		List<Student> testStudents = this.studentDAO.findAll();
		assertEquals(testStudents.size() > 0, true);
		}

	@Test
	@Transactional
	@Rollback
	void testDeleteStudent() {
		Student newStudent = bootStrapStudent.getStudent();
		Integer stId = newStudent.getStudent_id();
		//studentDAO.delete(newStudent);
		try {
			Student delStudent = this.studentDAO.findById(stId).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assertions.assertThatExceptionOfType(NoSuchFieldError.class);
		}
				
	}

	@Test
	@Transactional
	@Rollback
	void testUpdateStudent() {
		Student newStudent = bootStrapStudent.getStudent();
		Integer stId = newStudent.getStudent_id();
		Student stdToUpdate = this.studentDAO.findById(stId).get();
		stdToUpdate.setStudent_name("Alvin");
		Student studentUpdated = this.studentDAO.save(stdToUpdate);
		
		Assertions.assertThat(studentUpdated.getStudent_name()).isEqualTo("Alvin");
	}

	@Test
	@Transactional
	@Rollback
	void testGetStudentByID() {
		Student newStudent = bootStrapStudent.getStudent();
		Integer stId = newStudent.getStudent_id();
		Student student =this.studentDAO.findById(stId).get();
		Assertions.assertThat(student.getStudent_id().toString()).isEqualTo(stId);
	}

}
