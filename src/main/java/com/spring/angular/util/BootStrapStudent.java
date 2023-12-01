package com.spring.angular.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.angular.dao.StudentDAO;
import com.spring.angular.model.Student;

import lombok.NoArgsConstructor;


@Component
@NoArgsConstructor
public class BootStrapStudent {
	@Autowired
	private StudentDAO studentDAO;
	
	
	private Student student;
	
	private List<Student> students;

	
	
	public BootStrapStudent(StudentDAO studentDAO, Student student, List<Student> students) {
		
		this.studentDAO = studentDAO;
		this.student = student;
		this.students = students;
		
	}
	@Transactional
	private Student createStudent(String name) {
		Student newStudent = Student.builder()
							.student_name(name)
							.student_email("koidwdx@email.com")
							.student_branch("MCA")
					        .build();
		this.student = studentDAO.save(newStudent);
		return this.student;
		
	}
	
	public List<Student> createStudents() {
		students.add(createStudent("Manju"));
		students.add(createStudent("Alvin"));
		return this.students;
	}



	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}