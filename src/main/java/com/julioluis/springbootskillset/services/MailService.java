package com.julioluis.springbootskillset.services;

public interface MailService {

    void sendEmail();
    void sendEmail(String dear,String content);
}
