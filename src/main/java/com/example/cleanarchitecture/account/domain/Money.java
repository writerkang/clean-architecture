package com.example.cleanarchitecture.account.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Money {

    @Getter
    private final Long value;

    public static Money of(Long amount) {
        return new Money(amount);
    }
}
