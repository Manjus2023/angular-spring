package com.spring.angular.service;
import java.util.List;
import com.spring.angular.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> getStudents();
	public void deleteStudent(Integer id);
	public Student getStudentByID(Integer id);
	public Student updateStudent(Student student);


}
