package com.julioluis.springbootskillset.resources;

import com.julioluis.springbootskillset.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mails")
public class MailResource {

    @Autowired
    private MailService mailService;

    @PostMapping
    public ResponseEntity<Void> testEmail() {
        mailService.sendEmail("Juan","My First message using template");

        return ResponseEntity.ok().build();
    }
}
