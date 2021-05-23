package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Faculty;
import com.studentmanagement.studentmanagementauth.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService extends HibernateHelper<Faculty> {
    @Autowired
    FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        super(facultyRepository);
    }

}
