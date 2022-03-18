package com.example.daktariplus.model;

public class LoginModel {
    String id;
    String name;
    String access_token;
    String user_type;
    String email;

    public LoginModel(String id, String name, String access_token, String user_type, String email) {
        this.id = id;
        this.name = name;
        this.access_token = access_token;
        this.user_type = user_type;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}