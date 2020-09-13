package com.julioluis.springbootskillset.services;

import com.julioluis.springbootskillset.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findUserByUsername(String username);
    List<User> findAllUser();
}
