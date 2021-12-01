package com.example.inside.dto;

public class MessageDto {
    private String name;
    private String message;

    public MessageDto(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
