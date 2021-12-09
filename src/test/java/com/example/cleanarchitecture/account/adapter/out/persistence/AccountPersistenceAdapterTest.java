package com.example.cleanarchitecture.account.adapter.out.persistence;

import com.example.cleanarchitecture.account.domain.Account;
import com.example.cleanarchitecture.account.domain.AccountId;
import com.example.cleanarchitecture.account.domain.Money;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@Import({AccountPersistenceAdapter.class, AccountMapper.class})
@DataJpaTest
class AccountPersistenceAdapterTest {

    @Autowired
    private AccountPersistenceAdapter adapter;

    @Sql("classpath:AccountPersistenceAdapter.sql")
    @Test
    void loadAccount_succeed() {
        Account account = adapter.loadAccount(
            new AccountId(1L),
            LocalDateTime.of(2021, 12, 9, 0, 0));

        Assertions.assertEquals(Money.of(500L), account.calculateBalance());
    }
}
