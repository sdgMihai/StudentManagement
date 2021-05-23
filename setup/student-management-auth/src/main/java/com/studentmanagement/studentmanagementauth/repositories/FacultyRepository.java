package com.studentmanagement.studentmanagementauth.repositories;

import com.studentmanagement.studentmanagementauth.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
