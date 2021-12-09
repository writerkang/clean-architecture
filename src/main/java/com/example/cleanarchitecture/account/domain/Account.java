package com.example.cleanarchitecture.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    @EqualsAndHashCode.Include
    @Getter
    private final AccountId id;

    private final Money baselineBalance;

    public static Account withoutId(Money baselineBalance) {
        return new Account(null, baselineBalance);
    }

    public static Account withId(AccountId accountId, Money baselineBalance) {
        return new Account(accountId, baselineBalance);
    }


    public boolean withdraw(Money money, AccountId targetAccountId) {

        return true;
    }

    public boolean deposit(Money money, AccountId sourceAccountId) {

        return true;
    }

    public Money calculateBalance() {
        return this.baselineBalance;
    }
}
