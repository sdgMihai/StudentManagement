package com.studentmanagement.studentmanagementauth.controllers;

import com.studentmanagement.studentmanagementauth.entities.User;
import com.studentmanagement.studentmanagementauth.repositories.UserRepository;
import com.studentmanagement.studentmanagementauth.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController extends com.studentmanagement.studentmanagementauth.controllers.HibernateObjectController<User> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    private static final Logger log = LogManager.getLogger(UserController.class);

    @PostConstruct
    public void init(){
        this.init(userService, userRepository);
    }

    @GetMapping("/login/{login}")
    ResponseEntity<User> findUserByLogin(@PathVariable(value = "login") String login) {
        log.debug("get user by login:{}", login);
        log.debug("user {}", userRepository.findUserByLogin(login));
        Optional<User> user = userRepository.findUserByLogin(login);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
