package com.uday.student.dal.studentdal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

import com.uday.student.dal.studentdal.repos.StudentRepository;

import java.util.Optional;

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

	@Test
	public void testFindStudentById() {
		Optional<Student> student = studentRepository.findById(1l);
		System.out.println(student);
	}

	@Test
	public void testUpdateStudent() {
		Student student = studentRepository.findById(1l).get();
		student.setFee(40d);
		studentRepository.save(student);
	}

	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setId(1l);
		studentRepository.delete(student);
	}
	

}

