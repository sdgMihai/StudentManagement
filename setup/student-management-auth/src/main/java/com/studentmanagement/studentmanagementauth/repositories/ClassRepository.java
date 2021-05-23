package com.studentmanagement.studentmanagementauth.repositories;

import com.studentmanagement.studentmanagementauth.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findAllByYearAndMajorId(int year, long id);
}
