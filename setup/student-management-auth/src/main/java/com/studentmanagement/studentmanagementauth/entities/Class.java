package com.studentmanagement.studentmanagementauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "class")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Class implements HibernateObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "credit_points")
    @NotNull
    private int creditPoints;

//    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM('Optional','Obligatoriu','Alegere')")
    @NotNull
    private ClassType type;

    @Column(name = "year")
    @NotNull
    private int year;

    @Column(name = "semester")
    @NotNull
    private int semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Major major;

    @OneToMany(mappedBy = "clasa", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Grade> grades = new ArrayList<>();

    public Class() {
    }
}

enum ClassType {
    OPTIONAL("Optional"),
    Obligatoriu("Obligatoriu"),
    ALEGERE("Alegere");

    private String name;

    private ClassType(String name) {
        this.name = name;
    }
}