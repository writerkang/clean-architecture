package com.example.cleanarchitecture.user.adapter.in.web;

import com.example.cleanarchitecture.user.application.port.in.LoginCommand;
import com.example.cleanarchitecture.user.application.port.in.LoginUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/user/login")
    public void login(@RequestBody LoginDto dto) {

        LoginCommand command = new LoginCommand(dto.getUserId(), dto.getPassword());

        this.loginUseCase.login(command);
    }
}
