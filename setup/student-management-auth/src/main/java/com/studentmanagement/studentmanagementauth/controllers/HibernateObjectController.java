package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.HibernateObject;
import com.studentmanagement.studentmanagementauth.services.HibernateHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

public class HibernateObjectController<T extends HibernateObject> {

    HibernateHelper<T> service;
    JpaRepository<T, Long> repository;

    public void init(HibernateHelper<T> service,
                     JpaRepository<T, Long> repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    List<T> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<T> findById(@PathVariable(value = "id") int id) {
        T hibernateObject = service.findById(id);
        if(hibernateObject == null)
            return ResponseEntity.notFound().build();
        return ok(hibernateObject);
    }

    @PostMapping
    ResponseEntity<T> saveNewHibernateObject(@RequestBody T hibernateObject) {
        T response = service.saveToRepository(hibernateObject);
        if(response == null)
            return ResponseEntity.badRequest().body(hibernateObject);
        return ok(response);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<T> update(@PathVariable(value = "id") long id,
                                    @RequestBody T object) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        T updatedObject = service.update(id, object);

        if(updatedObject == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updatedObject);
    }
}
