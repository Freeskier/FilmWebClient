package com.client.DTOs;

public class UserForRegisterDTO {
    private String login;
    private String email;
    private String password;

    public UserForRegisterDTO(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }
}
