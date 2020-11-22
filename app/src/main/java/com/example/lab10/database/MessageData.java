package com.example.lab10.database;

public class MessageData {

    private String subject,message;

    public MessageData(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
