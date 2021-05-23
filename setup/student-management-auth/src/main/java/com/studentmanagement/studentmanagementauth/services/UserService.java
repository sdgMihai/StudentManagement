package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.User;
import com.studentmanagement.studentmanagementauth.repositories.UserRepository;
import com.studentmanagement.studentmanagementauth.repositories.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService  extends HibernateHelper<User>{
// modified to orig version

    private final UserRepository userRepository;
    UserTypeRepository userTypeRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    public User findByUserName(String username) {
        Optional<User> user = userRepository.findUserByLogin(username);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException("Username not found");
        }
        return user.get();
    }
}
