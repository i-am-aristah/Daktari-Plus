package com.example.daktariplus.model;


public class User {

    String id,name,user_type,email,remember_token;

    public User(String id, String name, String user_type, String email, String remember_token) {
        this.id = id;
        this.name = name;
        this.user_type = user_type;
        this.email = email;
        this.remember_token = remember_token;
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

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }
}