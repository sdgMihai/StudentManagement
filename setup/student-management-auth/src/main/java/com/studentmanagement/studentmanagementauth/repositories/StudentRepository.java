package com.studentmanagement.studentmanagementauth.repositories;


import com.studentmanagement.studentmanagementauth.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByUserLogin(String login);
    Boolean existsStudentByUserLogin(String login);
    Student findStudentByUserId(long id);
    Boolean existsStudentByUserId(long id);
}
