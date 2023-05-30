package com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.repository;

import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model.Student;

import java.util.List;

public interface StudentDao {
    Boolean saveStudent(Student student);

    List<Student> fetchAllStudents();
}
