package com.example.cleanarchitecture.user.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserJpaEntity {

    @Id
    private String userId;

    private String password;

    public String getUserId() {
        return userId;
    }

    public UserJpaEntity(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    protected UserJpaEntity() {}

    public String getPassword() {
        return password;
    }
}
