package com.julioluis.springbootskillset.resources;

import com.julioluis.springbootskillset.entities.User;
import com.julioluis.springbootskillset.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> userList=userService.findAllUser();

        return ResponseEntity.ok()
                .body(userList);
    }


}
