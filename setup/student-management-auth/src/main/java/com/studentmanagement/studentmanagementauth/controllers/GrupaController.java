package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Grupa;
import com.studentmanagement.studentmanagementauth.repositories.GrupaRepository;
import com.studentmanagement.studentmanagementauth.services.GrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/grupe")
public class GrupaController extends HibernateObjectController<Grupa> {
    @Autowired
    GrupaRepository grupaRepository;

    @Autowired
    GrupaService grupaService;

    @PostConstruct
    public void init(){
        this.init(grupaService, grupaRepository);
    }
}
