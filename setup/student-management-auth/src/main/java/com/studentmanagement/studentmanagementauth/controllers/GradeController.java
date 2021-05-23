package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Grade;
import com.studentmanagement.studentmanagementauth.repositories.ClassRepository;
import com.studentmanagement.studentmanagementauth.repositories.GradeRepository;
import com.studentmanagement.studentmanagementauth.repositories.StudentRepository;
import com.studentmanagement.studentmanagementauth.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    ClassRepository classRepository;
    StudentRepository studentRepository;
    GradeRepository gradeRepository;
    GradeService gradeService;

    @Autowired
    public GradeController(GradeRepository gradeRepository,
                           GradeService gradeService,
                           ClassRepository classRepository,
                           StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.gradeService = gradeService;
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @PostMapping
    Grade newGrade(@RequestBody Grade grade) {
        return  gradeRepository.save(grade);
    }

    @GetMapping("/student/{sin}")
    List<Grade> findStudentGrades(@PathVariable(value = "sin") long sin,
                                  @RequestParam(value = "year", required = false) Integer year) {
        if(year == null)
            return gradeRepository.findAllByStudentSin(sin);
        return gradeRepository.findAllByStudentSinAndClasaYear(sin, year);
    }

    @PutMapping("/student/{sin}/class/{classId}")
    ResponseEntity<Grade> modifyGrade(@PathVariable(value = "sin") long sin,
                                      @PathVariable(value = "classId") long classId,
                                      @RequestBody Grade grade) {
        if(sin != grade.getStudent().getSin() || classId != grade.getClasa().getId())
            return ResponseEntity.badRequest().build();
        if(!gradeRepository.existsByStudentSinAndClasaId(sin, classId)) {
            Grade newGrade = new Grade();
            if(!classRepository.existsById(classId) || !studentRepository.existsById(sin))
                return ResponseEntity.badRequest().build();
            newGrade.setClasa(grade.getClasa());
            newGrade.setStudent(grade.getStudent());
            newGrade.setGrade(grade.getGrade());
            return ResponseEntity.ok(gradeRepository.save(newGrade));
        }
        Grade grade1 = gradeRepository.findByStudentSinAndClasaId(sin, classId);
        grade1.setGrade(grade.getGrade());
        return ResponseEntity.ok(gradeRepository.save(grade1));
    }

    @GetMapping("/student/{sin}/class/{classId}")
    ResponseEntity<Grade> getGrade(@PathVariable(value = "sin") long sin,
                                   @PathVariable(value = "classId") long classId) {
        if(!gradeRepository.existsByStudentSinAndClasaId(sin, classId)) {
            return ResponseEntity.notFound().build();
        }
        Grade grade1 = gradeRepository.findByStudentSinAndClasaId(sin, classId);
        return ResponseEntity.ok(grade1);
    }

}
