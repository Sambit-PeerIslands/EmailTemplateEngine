package com.example.emailapp.email.service;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class EmailTemplateEngine {

    // Method to load the template based on language
    public String loadTemplate(String languageCode) throws IOException {
        // Load the appropriate template file based on the language
        String templateFilePath = "src/main/resources/templates/emailTemplate_" + languageCode + ".txt";
        return new String(Files.readAllBytes(Paths.get(templateFilePath)));
    }

    // This method will take a template string and a Map of key-value replacements
    public String generateEmail(String languageCode, Map<String, String> values) throws IOException {
        // Load the template for the requested language
        String template = loadTemplate(languageCode);

        // Create a StrSubstitutor to perform the substitution
        StrSubstitutor substitutor = new StrSubstitutor(values);

        // Replace placeholders in the template with the provided values
        return substitutor.replace(template);
    }
}
