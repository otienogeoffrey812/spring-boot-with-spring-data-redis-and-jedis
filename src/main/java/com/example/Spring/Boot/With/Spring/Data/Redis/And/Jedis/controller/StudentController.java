package com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.controller;

import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model.Student;
import com.example.Spring.Boot.With.Spring.Data.Redis.And.Jedis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/students")
    public ResponseEntity<List<Student>> fetchAllStudents(){

        List<Student> students;

        students =  studentService.fetchAllStudents();

        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> fetchStudentById(@PathVariable("id") long id){

        Student student;

        student =  studentService.fetchStudentById(id);

        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<String> updateStudent (@PathVariable("id") long id, @RequestBody Student student){
        Boolean result = studentService.updateStudent(id, student);

        if (result){
            return ResponseEntity.ok().body("Student Updated Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id){
        Boolean result = studentService.deleteStudentById(id);

        if (result){
            return ResponseEntity.ok().body("Student Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
