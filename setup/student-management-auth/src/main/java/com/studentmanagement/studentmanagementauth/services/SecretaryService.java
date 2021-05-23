package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Secretary;
import com.studentmanagement.studentmanagementauth.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretaryService extends HibernateHelper<Secretary> {

    @Autowired
    SecretaryRepository secretaryRepository;

    public SecretaryService(SecretaryRepository secretaryRepository) {
        super(secretaryRepository);
    }

    @Override
    public Secretary findById(long id) {
        if(!secretaryRepository.existsSecretaryByUserId(id))
            return null;
        return secretaryRepository.findSecretaryByUserId(id);
    }
}
