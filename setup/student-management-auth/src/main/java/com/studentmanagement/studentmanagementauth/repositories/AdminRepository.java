package com.studentmanagement.studentmanagementauth.repositories;

import com.studentmanagement.studentmanagementauth.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Boolean existsAdminByUserLogin(String login);
    Admin findAdminByUserLogin(String login);
    Admin findAdminByUserId(long id);
    Boolean existsAdminByUserId(long id);
}
