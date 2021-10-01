package com.client.DTOs;

import com.google.gson.annotations.SerializedName;

public class UserForLoginDTO {
    @SerializedName("Login")
    private String login;
    @SerializedName("Password")
    private String password;

    public UserForLoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
