package com.spring.angular.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.angular.dao.StudentDAO;
import com.spring.angular.model.Student;
import com.spring.angular.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentRepo;

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		Student studentToDelete = studentRepo.findById(id).get();
		studentRepo.delete(studentToDelete);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentByID(Integer id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}

}
