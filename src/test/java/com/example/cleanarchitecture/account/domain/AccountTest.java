package com.example.cleanarchitecture.account.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void withDraw_succeeds() {
        AccountId accountId = new AccountId(1L);
        Account account = Account.withId(accountId, new Money(10000L));

        boolean success = account.withdraw(new Money(5000L), new AccountId(20L));

        assertEquals(true, success);
    }

}
