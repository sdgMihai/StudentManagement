package com.studentmanagement.studentmanagementauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "secretary")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Secretary implements HibernateObject, Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "faculty")
    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;

    public Secretary() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.studentmanagement.studentmanagementauth.entities.Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(com.studentmanagement.studentmanagementauth.entities.Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
