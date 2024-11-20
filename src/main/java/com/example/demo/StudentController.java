package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {

    @GetMapping(value = "/student/{studentId}")
    public Student getTestData(@PathVariable Integer studentId) {
        
        Student student = new Student();
        student.setName("Peter");
        student.setId(studentId);

        return student;
    }
}