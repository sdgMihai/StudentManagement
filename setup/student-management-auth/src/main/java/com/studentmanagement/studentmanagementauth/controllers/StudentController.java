package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Student;
import com.studentmanagement.studentmanagementauth.repositories.StudentRepository;
import com.studentmanagement.studentmanagementauth.repositories.UserRepository;
import com.studentmanagement.studentmanagementauth.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/students")
public class StudentController extends HibernateObjectController<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        init(studentService, studentRepository);
    }

    @Override
    @PutMapping(value = "/{id}")
    ResponseEntity<Student> update(@PathVariable(value = "id") long id,
                                   @RequestBody Student student) {
        Student updatedStudent = studentService.update(id, student);

        if(!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if(updatedStudent == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping(value = "/username/{username}")
    ResponseEntity<Student> getByUsername(@PathVariable(value = "username") String username) {
        if(!studentRepository.existsStudentByUserLogin(username))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentRepository.findStudentByUserLogin(username));
    }
}
