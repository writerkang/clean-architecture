package com.example.cleanarchitecture.user.application;

import com.example.cleanarchitecture.user.application.port.in.LoginCommand;
import com.example.cleanarchitecture.user.application.port.in.LoginUseCase;
import com.example.cleanarchitecture.user.application.port.out.LoadUserPort;
import com.example.cleanarchitecture.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class LoginService implements LoginUseCase {

    private final LoadUserPort loadUserPort;

    public LoginService(
        LoadUserPort loadUserPort) {
        this.loadUserPort = loadUserPort;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean login(LoginCommand command) {

        User user = this.loadUserPort.loadUser(command.getUserId());

        if (user != null) {
            return user.isValidPassword(command.getPassword());
        }

        return false;
    }
}
