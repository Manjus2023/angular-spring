package com.spring.angular.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.angular.model.Student;
@Repository
public interface StudentDAO extends JpaRepository<Student,Integer>{
	
}



	