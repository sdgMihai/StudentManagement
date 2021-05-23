package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Admin;
import com.studentmanagement.studentmanagementauth.repositories.AdminRepository;
import com.studentmanagement.studentmanagementauth.repositories.UserRepository;
import com.studentmanagement.studentmanagementauth.services.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admins")
public class AdminController extends HibernateObjectController<Admin> {

    AdminRepository adminRepository;
    AdminService adminService;
    private static final Logger log = LogManager.getLogger(AdminController.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository, AdminService adminService) {
        init(adminService, adminRepository);
        this.adminRepository = adminRepository;
        this.adminService = adminService;
    }

    @Override
    @PutMapping(value = "/{id}")
    ResponseEntity<Admin> update(@PathVariable(value = "id") long id,
                                   @RequestBody Admin admin) {
        log.debug("received admin {}", admin);
        Admin adminUpdated = adminService.update(id, admin);
        log.debug("retrieve admin");

        if(!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if(adminUpdated == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(adminUpdated);
    }

    @GetMapping(value = "/username/{username}")
    ResponseEntity<Admin> getByUsername(@PathVariable(value = "username") String username) {
        log.debug("getByusername {}", username);
        if(!adminRepository.existsAdminByUserLogin(username))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(adminRepository.findAdminByUserLogin(username));
    }
}
