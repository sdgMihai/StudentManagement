package com.studentmanagement.studentmanagementauth.repositories;

import com.studentmanagement.studentmanagementauth.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findAllByStudentSin(long sin);
    List<Grade> findAllByStudentSinAndClasaYear(long sin, int year);
    Grade findByStudentSinAndClasaId(long sin, long classId);
    Boolean existsByStudentSinAndClasaId(long sin, long classId);
}
