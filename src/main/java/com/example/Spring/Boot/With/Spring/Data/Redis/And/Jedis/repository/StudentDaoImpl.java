package com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.repository;

import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";
    @Override
    public Boolean saveStudent(Student student) {
        try {
            redisTemplate.opsForHash().put(KEY, String.valueOf(student.getId()), student);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> fetchAllStudents() {

        List<Student> students;

        students = redisTemplate.opsForHash().values(KEY);
        return students;
    }

    @Override
    public Student fetchStudentById(long id) {
        Student student;

        student = (Student) redisTemplate.opsForHash().get(KEY, String.valueOf(id));
        return student;
    }
}
