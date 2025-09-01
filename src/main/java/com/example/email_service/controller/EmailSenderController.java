package com.example.email_service.controller;

import com.example.email_service.application.EmailSenderService;
import com.example.email_service.dto.EmailRequest;
import com.example.email_service.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService){
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<Void> sendEmail(EmailRequest emailRequest){
        try {
            emailSenderService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
            return ResponseEntity.ok().build();
        }catch (EmailServiceException e){
            return ResponseEntity.badRequest().build();
        }

    }
}
