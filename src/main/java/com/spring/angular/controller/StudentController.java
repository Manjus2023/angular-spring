package com.spring.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.model.Student;
import com.spring.angular.service.impl.StudentServiceImpl;

@RestController
public class StudentController{
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@GetMapping("/api/students-list")
	public List<Student> getAllStudentsList()
	{			
		return studentServiceImpl.getStudents();
	}
	
	@GetMapping("/api/student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id)
	
	{			
		Student std = studentServiceImpl.getStudentByID(id);
		return std;
	}
	
	@PostMapping("/api/save-student")
	public void  saveStudent(@RequestBody Student student) {

		 studentServiceImpl.saveStudent(student);
	
	}
	@DeleteMapping("/api/delete-student/{student_id}")
	public void deleteStudent(@PathVariable("student_id") Integer studentId) {

		studentServiceImpl.deleteStudent(studentId);
	
	}
	@PutMapping("/api/update-student/{student_id}")
	public Student updateStudent(@RequestBody Student newStudent,@PathVariable ("student_id")int student_id) {
		
		Student student = studentServiceImpl.getStudentByID(student_id);
		
		//Update the value of the student
		
		student.setStudent_name(newStudent.getStudent_name());
		student.setStudent_email(newStudent.getStudent_email());
		student.setStudent_branch(newStudent.getStudent_branch());
								
		return studentServiceImpl.updateStudent(student);

		
}
}