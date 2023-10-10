package com.ceyentra.junitWithMockito.repo;

import com.ceyentra.junitWithMockito.dto.StudentDTO;
import com.ceyentra.junitWithMockito.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query(value = "SELECT new com.ceyentra.junitWithMockito.dto.StudentDTO(studentId,studentName,address,contact) FROM Student WHERE (?1=0L OR studentId=?1) AND (?2 IS NULL OR studentName LIKE %?2%)")
    List<StudentDTO> getFilterStudent(long studentId, String studentName);
}
