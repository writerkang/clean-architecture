package com.example.cleanarchitecture.account.application;

import com.example.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.example.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.example.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.example.cleanarchitecture.account.domain.Account;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {

        Account sourceAccount = loadAccountPort.loadAccount(command.getSourceAccountId(), LocalDateTime.now());

        return sourceAccount.withdraw(command.getMoney(), command.getTargetAccountId());
    }
}
