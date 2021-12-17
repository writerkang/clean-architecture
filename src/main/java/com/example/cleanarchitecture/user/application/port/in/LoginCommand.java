package com.example.cleanarchitecture.user.application.port.in;

import com.example.cleanarchitecture.shared.SelfValidating;
import javax.validation.constraints.NotNull;

public class LoginCommand extends SelfValidating<LoginCommand> {

    @NotNull
    private final String userId;

    @NotNull
    private final String password;

    public LoginCommand(String userId, String password) {
        this.userId = userId;
        this.password = password;

        this.validateSelf();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
