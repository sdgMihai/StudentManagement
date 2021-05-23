package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Seria;
import com.studentmanagement.studentmanagementauth.repositories.SeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriaService extends com.studentmanagement.studentmanagementauth.services.HibernateHelper<Seria> {

    @Autowired
    private SeriaRepository seriaRepository;

    public SeriaService(SeriaRepository seriaRepository) {
        super(seriaRepository);
    }
}
