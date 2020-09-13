package com.julioluis.springbootskillset.services.impl;

import com.julioluis.springbootskillset.entities.User;
import com.julioluis.springbootskillset.repositories.UserRepository;
import com.julioluis.springbootskillset.services.UserService;
import com.julioluis.springbootskillset.util.BusinessException;
import com.julioluis.springbootskillset.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHelper userHelper;

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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUsername(s);

        if(!user.isPresent())
            throw new UsernameNotFoundException(s);

        try {
            UserDetails userDetails  = userHelper.toUserDetail(user.get());
            return userDetails;
        } catch (BusinessException e) {
            return null;
        }
    }
}
