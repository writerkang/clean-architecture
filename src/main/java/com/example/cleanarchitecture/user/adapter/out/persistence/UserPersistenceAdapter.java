package com.example.cleanarchitecture.user.adapter.out.persistence;

import com.example.cleanarchitecture.user.application.port.out.LoadUserPort;
import com.example.cleanarchitecture.user.domain.User;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
class UserPersistenceAdapter implements LoadUserPort {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public UserPersistenceAdapter(
        UserRepository repository,
        UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Override
    public User loadUser(String userId) {

        UserJpaEntity user = this.repository.findById(userId)
            .orElseThrow(EntityNotFoundException::new);

        return this.userMapper.mapToDomainEntity(user);
    }
}
