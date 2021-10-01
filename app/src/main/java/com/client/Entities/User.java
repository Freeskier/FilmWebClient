package com.client.Entities;

public class User {
    private int id;
    private String login="";
    private String password="";
    private String email="";
    private String firstName="";
    private String lastName="";

    public User(){
        login="";
        password="";
        email="";
        firstName="";
        lastName="";

    }
    public User(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String email) {
        super();
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String login, String password, String email, String firstName, String lastName) {
        super();
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
