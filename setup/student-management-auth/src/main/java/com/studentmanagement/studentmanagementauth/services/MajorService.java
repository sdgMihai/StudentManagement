package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Major;
import com.studentmanagement.studentmanagementauth.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService extends com.studentmanagement.studentmanagementauth.services.HibernateHelper<Major> {

    @Autowired
    private MajorRepository majorRepository;

    public MajorService(MajorRepository majorRepository) {
        super(majorRepository);
    }
}
