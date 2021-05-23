package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.User;
import com.studentmanagement.studentmanagementauth.entities.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        User user;
        user = userService.findByUserName(userName);
        HashSet<UserType> roles = new HashSet<>();
        roles.add(user.getUserType());
        List<GrantedAuthority> authorities = getUserAuthority(roles);
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<UserType> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (UserType role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getType()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, authorities);
    }
}
