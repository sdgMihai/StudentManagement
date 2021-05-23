package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Class;
import com.studentmanagement.studentmanagementauth.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService extends HibernateHelper<Class> {

    ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        super(classRepository);
        this.classRepository = classRepository;
    }
}
