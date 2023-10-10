package com.ceyentra.junitWithMockito.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentSchool {

    @Id
    @GeneratedValue
    private long studentSchoolId;
    @ManyToOne
    private Student student;
    @ManyToOne
    private School school;
}
