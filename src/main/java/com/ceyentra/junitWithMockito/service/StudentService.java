package com.ceyentra.junitWithMockito.service;

import com.ceyentra.junitWithMockito.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);

    void updateStudent(StudentDTO studentDTO);

    List<StudentDTO> getStudents(long studentId,String studentName);

    void deleteStudent(long studentId);
}
