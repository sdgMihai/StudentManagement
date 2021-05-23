package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Major;
import com.studentmanagement.studentmanagementauth.repositories.MajorRepository;
import com.studentmanagement.studentmanagementauth.services.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/majors")
public class MajorController extends HibernateObjectController<Major> {

    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private MajorService majorService;

    @PostConstruct
    public void init() {
        this.init(majorService, majorRepository);
    }
}
