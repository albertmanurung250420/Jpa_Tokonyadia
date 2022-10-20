package com.mandiri.jpatokonyadia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("albertmanurung250420@gmail.com");
        simpleMailMessage.setTo("joshuadiansiahaan29@gmail.com");
        simpleMailMessage.setSubject("Pengiriman email Melalui Spring");
        simpleMailMessage.setText("Percobaaan");
        javaMailSender.send(simpleMailMessage);
    }
}
