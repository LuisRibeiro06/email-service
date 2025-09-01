package com.example.email_service.service;

public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
