package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Grupa;
import com.studentmanagement.studentmanagementauth.repositories.GrupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupaService extends com.studentmanagement.studentmanagementauth.services.HibernateHelper<Grupa> {

    @Autowired
    GrupaRepository grupaRepository;

    public GrupaService(GrupaRepository grupaRepository) {
        super(grupaRepository);
    }
}
