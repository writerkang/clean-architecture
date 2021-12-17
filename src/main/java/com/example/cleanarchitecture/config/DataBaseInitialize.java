package com.example.cleanarchitecture.config;

import com.example.cleanarchitecture.user.adapter.out.persistence.UserJpaEntity;
import com.example.cleanarchitecture.user.adapter.out.persistence.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DataBaseInitialize {

    private final UserRepository userRepository;

    @Bean
    ApplicationRunner init() {
        return args -> DataBaseInitialize.this.userRepository.save(
            new UserJpaEntity("khlee", "1234"));
    }

    public DataBaseInitialize(
        UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
