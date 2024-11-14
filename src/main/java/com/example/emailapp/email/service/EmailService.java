package com.example.emailapp.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {
    private final EmailTemplateEngine emailTemplateEngine;

    @Autowired
    public EmailService(EmailTemplateEngine emailTemplateEngine) {
        this.emailTemplateEngine = emailTemplateEngine;
    }

    public String generateWelcomeEmail(String userName, String registrationDate, String languageCode) throws IOException {

        // Define the dynamic values
        Map<String, String> values = new HashMap<>();
        values.put("userName", userName);
        values.put("registrationDate", registrationDate);
        values.put("companyName", "PeerIslands");

        // Generate the email using template engine
        return emailTemplateEngine.generateEmail(languageCode, values);
    }
}
