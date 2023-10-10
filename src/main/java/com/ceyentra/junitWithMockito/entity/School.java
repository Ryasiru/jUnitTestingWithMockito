package com.ceyentra.junitWithMockito.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class School {

    @Id
    @GeneratedValue
    private long schoolId;
    private String schoolName;

    @OneToMany(mappedBy = "school")
    List<StudentSchool> studentSchoolList;
}
