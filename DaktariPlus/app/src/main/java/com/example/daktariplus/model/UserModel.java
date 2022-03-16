package com.example.daktariplus.model;


public class UserModel {

    User user;
    String token;


    public UserModel(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String tpken) {
        this.token = tpken;
    }
}