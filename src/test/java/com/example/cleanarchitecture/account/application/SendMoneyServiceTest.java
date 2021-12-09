package com.example.cleanarchitecture.account.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.example.cleanarchitecture.account.domain.Account;
import com.example.cleanarchitecture.account.domain.AccountId;
import com.example.cleanarchitecture.account.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SendMoneyServiceTest {

    private SendMoneyService sendMoneyService;

    @Test
    void sendMoney_succeeds() {
        sendMoneyService = new SendMoneyService(null);

        Account sourceAccount = Account.withId(new AccountId(1L), Money.of(50000L));
        Account targetAccount = Account.withId(new AccountId(2L), Money.of(30000L));

        Money money = Money.of(10000L);

        boolean success = sendMoneyService.sendMoney(
            new SendMoneyCommand(sourceAccount.getId(), targetAccount.getId(), money));

        assertEquals(true, success);
    }

}
