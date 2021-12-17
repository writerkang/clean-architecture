package com.example.cleanarchitecture.user.adapter.out.persistence;

import com.example.cleanarchitecture.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    User mapToDomainEntity(UserJpaEntity entity) {

        return new User(entity.getUserId(), entity.getPassword());
    }
}
