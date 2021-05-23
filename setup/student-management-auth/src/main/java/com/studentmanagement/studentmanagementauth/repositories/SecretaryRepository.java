package com.studentmanagement.studentmanagementauth.repositories;

import com.studentmanagement.studentmanagementauth.entities.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
    Secretary findSecretaryByUserLogin(String login);
    Boolean existsSecretaryByUserLogin(String login);
    Secretary findSecretaryByUserId(long id);
    Boolean existsSecretaryByUserId(long id);
}
