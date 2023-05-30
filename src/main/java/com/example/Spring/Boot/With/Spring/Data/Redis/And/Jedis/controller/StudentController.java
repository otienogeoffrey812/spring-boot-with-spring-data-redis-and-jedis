package com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.controller;

import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model.Student;
import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/v1/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        Boolean result = studentService.saveStudent(student);

        if (result){
            return ResponseEntity.ok("Student Created Successfully");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
