package com.example.cleanarchitecture.account.adapter.out.persistence;

import com.example.cleanarchitecture.account.domain.Account;
import com.example.cleanarchitecture.account.domain.AccountId;
import com.example.cleanarchitecture.account.domain.Money;
import org.springframework.stereotype.Component;

@Component
class AccountMapper {

    Account mapToDomainEntity(
        AccountJpaEntity account) {

        return Account.withId(new AccountId(account.getId()), Money.of(account.getBalance()));
    }

}
