package com.mandiri.jpatokonyadia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandiri.jpatokonyadia.dto.Author;
import com.mandiri.jpatokonyadia.dto.Book;
import com.mandiri.jpatokonyadia.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CobaController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    EmailService emailService;

    @PostMapping("/coba")
    public String coba() throws JsonProcessingException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Author author = new Author("Udin", (Date) sdf.parse("2003-08-17"));
        Book book = new Book("Sebuah seni untuk bodoamat", 69,author);
        String json = objectMapper.writeValueAsString(book);
        return json;
    }

    @GetMapping("/coba1")
    public void coba1() throws JsonProcessingException {
        String json = "{\"name\":\"Tere Live\", \"birthDate\":\"1987-09-02\"}";
        Author author = objectMapper.readValue(json,Author.class);
        System.out.println(author.getName());
        System.out.println(author.getBirthDate());
    }

    @GetMapping("/coba2")
    public void coba2(@RequestParam Timestamp timestampParam) throws JsonProcessingException {
        Long theCurrentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(theCurrentTime);
        System.out.println(theCurrentTime);
        System.out.println(timestamp);
        System.out.println(timestampParam);
    }

    @GetMapping("/send")
    public void sendEmail(){
        emailService.sendSimpleMail();
    }
}
