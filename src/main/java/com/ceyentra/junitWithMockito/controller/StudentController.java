package com.ceyentra.junitWithMockito.controller;

import com.ceyentra.junitWithMockito.dto.StudentDTO;
import com.ceyentra.junitWithMockito.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO dto = studentService.addStudent(studentDTO);
        return new ResponseEntity<StudentDTO>(dto, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateStudent(@RequestBody StudentDTO studentDTO){
        studentService.updateStudent(studentDTO);
        return new ResponseEntity<String>("Student Updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteStudent(@PathVariable long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<String>("Student Deleted", HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getFilterStudents(@RequestParam(value = "studentId",required = false,defaultValue = "0")long studentId,
                                                           @RequestParam(value = "studentName",required = false)String studentName){
        return studentService.getStudents(studentId, studentName);
    }
}
