package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Class;
import com.studentmanagement.studentmanagementauth.repositories.ClassRepository;
import com.studentmanagement.studentmanagementauth.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classes")
public class ClassController extends HibernateObjectController<Class> {

    ClassService classService;
    ClassRepository classRepository;

    @Autowired
    public ClassController(ClassRepository classRepository, ClassService classService) {
        init(classService, classRepository);
        this.classService = classService;
        this.classRepository = classRepository;
    }

    @GetMapping("/year/{year}/major/{major}")
    List<Class> findAllByYearAndMajorName(@PathVariable(value = "year") int year,
                                          @PathVariable(value = "major") long major) {
        return classRepository.findAllByYearAndMajorId(year, major);
    }
}
