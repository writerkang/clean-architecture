package com.example.cleanarchitecture.user.application.port.out;

import com.example.cleanarchitecture.user.domain.User;

public interface LoadUserPort {

    User loadUser(String userId);

}
