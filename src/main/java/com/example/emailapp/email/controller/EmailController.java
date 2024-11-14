package com.example.emailapp.email.controller;

import com.example.emailapp.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    //http://localhost:8080/generate-email?userName=Sambit&registrationDate=2024-11-12&languageCode=en
    @GetMapping("/generate-email")
    public String generateEmail(@RequestParam String userName, @RequestParam String registrationDate, @RequestParam String languageCode) throws  IOException {
        return emailService.generateWelcomeEmail(userName, registrationDate, languageCode);
    }

}