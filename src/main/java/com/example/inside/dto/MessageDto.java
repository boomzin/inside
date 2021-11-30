package com.example.inside.dto;

public class MessageDto {
    private String username;
    private String message;

    public MessageDto(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
