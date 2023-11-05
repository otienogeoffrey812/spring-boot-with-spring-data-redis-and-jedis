package com.artman.Spring.Boot.With.Spring.Data.Redis.And.Jedis.service;

import com.artman.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model.Student;

import java.util.List;

public interface StudentService {

    Boolean saveStudent(Student student);

    List<Student> fetchAllStudents();

    Student fetchStudentById(long id);

    Boolean updateStudent(long id, Student student);

    Boolean deleteStudentById(long id);
}
