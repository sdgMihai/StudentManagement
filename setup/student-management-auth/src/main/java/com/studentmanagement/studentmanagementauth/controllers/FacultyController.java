package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Faculty;
import com.studentmanagement.studentmanagementauth.repositories.FacultyRepository;
import com.studentmanagement.studentmanagementauth.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController extends  HibernateObjectController<Faculty> {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    FacultyService facultyService;

    @PostConstruct
    public void init(){
        this.init(facultyService, facultyRepository);
    }


}
