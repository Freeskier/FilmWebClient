package com.client.DTOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserToResponseDTO {
    @Expose
    @SerializedName("id")
    private int ID;
    @Expose
    @SerializedName("login")
    private String login;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("firstName")
    private String firstName;
    @Expose
    @SerializedName("lastName")
    private String lastName;
    @Expose
    @SerializedName("token")
    private String token;

    public UserToResponseDTO(int ID, String login, String email, String firstName, String lastName, String token) {
        this.ID = ID;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
