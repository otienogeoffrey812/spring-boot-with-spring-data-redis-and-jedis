package com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.service;

import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model.Student;
import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    @Override
    public Boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public List<Student> fetchAllStudents() {
        return studentDao.fetchAllStudents();
    }

    @Override
    public Student fetchStudentById(long id) {
        return studentDao.fetchStudentById(id);
    }
}
