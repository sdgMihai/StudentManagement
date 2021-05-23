package com.studentmanagement.studentmanagementauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements HibernateObject, Serializable {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "student_identification_number")
    @Id
    private Long sin;

    @NotNull
    @Column(name = "father_initial")
    private String father_initial;

    @NotNull
    @Column(name = "cnp")
    private long cnp;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupa")
    private Grupa grupa;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Grade> grades = new ArrayList<>();

    public Student() {
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getSin() {
        return sin;
    }

    public void setSin(Long sin) {
        this.sin = sin;
    }

    public String getFather_initial() {
        return father_initial;
    }

    public void setFather_initial(String father_initial) {
        this.father_initial = father_initial;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    @JsonIgnore
    public Long getId() {
        return getUser().getId();
    }

    @Override
    public void setId(Long id) {
        getUser().setId(id);
    }

}
