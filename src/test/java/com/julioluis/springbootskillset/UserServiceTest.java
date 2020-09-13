package com.julioluis.springbootskillset;

import com.julioluis.springbootskillset.entities.User;
import com.julioluis.springbootskillset.repositories.UserRepository;
import com.julioluis.springbootskillset.services.impl.UserServiceIml;
import com.julioluis.springbootskillset.util.UserHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserHelper userHelper;

    @InjectMocks
    private UserServiceIml userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testFindUserByNameSuccessful() {
        final String USERNAME="admin";
        User user=new User();
        Optional<User> userOptional=Optional.of(user);
        when(userRepository.findByUsername(anyString())).thenReturn(userOptional);
        User userFound=userService.findUserByUsername(USERNAME);
        assertNotNull(userFound);
    }

    @Test
    public void testFindUserByNameFail() {
        final String USERNAME="username";
        Optional<User> userOptional=Optional.empty();
        when(userRepository.findByUsername(anyString())).thenReturn(userOptional);
        User userFound=userService.findUserByUsername(USERNAME);
        assertNull(userFound);
    }

    @Test
    public void testFindUserByUsername() {
        String username="username";
        User user=new User();
        user.setId(1);
        Optional<User> userOptional=Optional.of(user);

        when(userRepository.findByUsername(anyString())).thenReturn(userOptional);

        User userFound=userService.findUserByUsername(username);
        assertNotNull(userFound);
        assertNotNull(userFound.getId());
    }


}
