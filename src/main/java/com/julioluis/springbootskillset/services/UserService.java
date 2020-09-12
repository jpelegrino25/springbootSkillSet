package com.julioluis.springbootskillset.services;

import com.julioluis.springbootskillset.entities.User;

import java.util.List;

public interface UserService {

    User findUserByUsername(String username);
    List<User> findAllUser();
}
