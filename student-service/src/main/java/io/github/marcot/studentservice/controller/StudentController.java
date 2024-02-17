package io.github.marcot.studentservice.controller;

import io.github.marcot.studentservice.StudentServiceApplication;
import io.github.marcot.studentservice.model.Student;
import io.github.marcot.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentService.sendMessage(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
