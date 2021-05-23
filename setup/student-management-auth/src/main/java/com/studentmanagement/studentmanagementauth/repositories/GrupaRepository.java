package com.studentmanagement.studentmanagementauth.repositories;

import com.studentmanagement.studentmanagementauth.entities.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {

}
