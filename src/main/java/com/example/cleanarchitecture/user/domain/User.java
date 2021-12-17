package com.example.cleanarchitecture.user.domain;

public class User {

    private String userId;

    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public boolean isValidPassword(String input) {
        return input.equals(this.password);
    }
}
