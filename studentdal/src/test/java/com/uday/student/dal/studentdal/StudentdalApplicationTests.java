package com.uday.student.dal.studentdal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uday.student.dal.studentdal.repos.StudentRepository;
import com.uday.student.dal.studentdal.entities.Student;






@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {

		Student student = new Student();
		student.setName("John");
		student.setCourse("Java Web Services");
		student.setFee(30d);

		studentRepository.save(student);

	}

}

