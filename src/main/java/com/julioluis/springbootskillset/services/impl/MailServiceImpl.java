package com.julioluis.springbootskillset.services.impl;

import com.julioluis.springbootskillset.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail() {

        SimpleMailMessage msg=new SimpleMailMessage();
        String emails[]={"jpelegrino@gmail.com"};
        msg.setTo(emails);
        msg.setSubject("Mail sender from spring boot");
        msg.setText("Hello World \n from spring boot");

        javaMailSender.send(msg);

    }

    @Override
    public void sendEmail(String dear, String content) {
        SimpleMailMessage msg=new SimpleMailMessage();
        String emails[]={"jpelegrino@gmail.com"};
        msg.setTo(emails);
        msg.setSubject("Custom Message");
        msg.setText(String.format("Dear %s, \n\n%s ",dear,content));

        javaMailSender.send(msg);


    }
}
