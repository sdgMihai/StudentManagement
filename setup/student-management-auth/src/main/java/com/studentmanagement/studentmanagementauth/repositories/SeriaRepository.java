package com.studentmanagement.studentmanagementauth.repositories;

import com.studentmanagement.studentmanagementauth.entities.Seria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriaRepository extends JpaRepository<Seria, Long> {
}
