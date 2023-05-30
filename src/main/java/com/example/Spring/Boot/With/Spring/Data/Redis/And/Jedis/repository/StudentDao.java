package com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.repository;

import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model.Student;

public interface StudentDao {
    Boolean saveStudent(Student student);
}
