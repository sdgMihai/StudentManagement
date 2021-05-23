package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.Student;
import com.studentmanagement.studentmanagementauth.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends com.studentmanagement.studentmanagementauth.services.HibernateHelper<Student> {

    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        super(studentRepository);
    }

    @Override
    public Student findById(long id) {
        if(!studentRepository.existsStudentByUserId(id))
            return null;
        return studentRepository.findStudentByUserId(id);
    }
}
