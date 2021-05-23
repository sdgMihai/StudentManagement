package com.studentmanagement.studentmanagementauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "grades")
public class Grade {

    @EmbeddedId
    @JsonIgnore
    private GradeId gradeId = new GradeId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("classId")
    @JoinColumn(name = "class_id")
    private com.studentmanagement.studentmanagementauth.entities.Class clasa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sin")
    @JoinColumn(name = "student_identification_number")
    private com.studentmanagement.studentmanagementauth.entities.Student student;

    @Column(name = "grade")
    private Integer grade;

    public Grade() {
    }

    public Grade(GradeId gradeId, com.studentmanagement.studentmanagementauth.entities.Class clasa, com.studentmanagement.studentmanagementauth.entities.Student student, int grade) {
        this.gradeId = gradeId;
        this.clasa = clasa;
        this.student = student;
        this.grade = grade;
    }
}
