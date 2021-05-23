package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.Secretary;
import com.studentmanagement.studentmanagementauth.repositories.SecretaryRepository;
import com.studentmanagement.studentmanagementauth.repositories.UserRepository;
import com.studentmanagement.studentmanagementauth.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/secretaries")
public class SecretaryController extends HibernateObjectController<Secretary> {

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private SecretaryService secretaryService;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        init(secretaryService, secretaryRepository);
    }

    @Override
    @PutMapping(value = "/{id}")
    ResponseEntity<Secretary> update(@PathVariable(value = "id") long id,
                                     @RequestBody Secretary secretary) {
        Secretary updatedSecretary = secretaryService.update(id, secretary);

        if(!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if(updatedSecretary == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updatedSecretary);
    }

    @GetMapping(value = "/username/{username}")
    ResponseEntity<Secretary> getByUsername(@PathVariable(value = "username") String username) {
        if(!secretaryRepository.existsSecretaryByUserLogin(username))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(secretaryRepository.findSecretaryByUserLogin(username));
    }
}
