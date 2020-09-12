package com.julioluis.springbootskillset.services.impl;

import com.julioluis.springbootskillset.entities.User;
import com.julioluis.springbootskillset.repositories.UserRepository;
import com.julioluis.springbootskillset.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.getAllActiveUsers();
    }
}
