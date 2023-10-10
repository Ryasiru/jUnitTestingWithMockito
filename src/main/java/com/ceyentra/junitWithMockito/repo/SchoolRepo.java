package com.ceyentra.junitWithMockito.repo;

import com.ceyentra.junitWithMockito.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School,Long> {
}
