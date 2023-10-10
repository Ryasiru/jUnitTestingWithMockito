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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private long studentId;
    private String studentName;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "student")
    List<StudentSchool> studentSchoolList;
}
