package com.example.cleanarchitecture.account.application;

import com.example.cleanarchitecture.account.application.port.in.GetAccountBalanceQuery;
import com.example.cleanarchitecture.account.domain.AccountId;
import com.example.cleanarchitecture.account.domain.Money;

class GetAccountBalanceService implements GetAccountBalanceQuery {

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return null;
    }
}
