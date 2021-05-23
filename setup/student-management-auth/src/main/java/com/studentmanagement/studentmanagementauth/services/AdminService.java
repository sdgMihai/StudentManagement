package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Admin;
import com.studentmanagement.studentmanagementauth.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends HibernateHelper<Admin> {

    @Autowired
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        super(adminRepository);
    }

    @Override
    public Admin findById(long id) {
        if(!adminRepository.existsAdminByUserId(id))
            return null;
        return adminRepository.findAdminByUserId(id);
    }
}
