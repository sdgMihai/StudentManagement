package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Seria;
import com.studentmanagement.studentmanagementauth.repositories.SeriaRepository;
import com.studentmanagement.studentmanagementauth.services.SeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/serii")
public class SeriaController extends HibernateObjectController<Seria> {

    @Autowired
    private SeriaRepository seriaRepository;

    @Autowired
    private SeriaService seriaService;

    @PostConstruct
    public void init() {
        init(seriaService, seriaRepository);
    }
}
