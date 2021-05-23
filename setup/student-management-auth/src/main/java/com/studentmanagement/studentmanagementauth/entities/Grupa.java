package com.studentmanagement.studentmanagementauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Grupa implements HibernateObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JoinColumn(name = "seria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Seria seria;

    @NotNull
    @Column(name = "number")
    private int number;

    @JsonIgnore
    @OneToMany(mappedBy = "grupa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major")
    private Major major;

    public Grupa() {
    }

    public com.studentmanagement.studentmanagementauth.entities.Major getMajor() {
        return major;
    }

    public void setMajor(com.studentmanagement.studentmanagementauth.entities.Major major) {
        this.major = major;
    }

    public List<com.studentmanagement.studentmanagementauth.entities.Student> getStudents() {
        return students;
    }

    public void setStudents(List<com.studentmanagement.studentmanagementauth.entities.Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.studentmanagement.studentmanagementauth.entities.Seria getSeria() {
        return seria;
    }

    public void setSeria(com.studentmanagement.studentmanagementauth.entities.Seria seria) {
        this.seria = seria;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
