package com.example.inside.dto;

public class AuthenticationRequestDto {
    private String name;
    private String password;

    public AuthenticationRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
