package com.ceyentra.junitWithMockito.repo;

import com.ceyentra.junitWithMockito.entity.StudentSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSchoolRepo extends JpaRepository<StudentSchool,Long>
{
}
