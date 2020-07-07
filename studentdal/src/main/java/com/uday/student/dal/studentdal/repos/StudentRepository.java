package com.uday.student.dal.studentdal.repos;

import org.springframework.data.repository.CrudRepository;

import com.uday.student.dal.studentdal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}