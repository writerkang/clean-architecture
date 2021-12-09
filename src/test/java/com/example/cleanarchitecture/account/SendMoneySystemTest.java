package com.example.cleanarchitecture.account;


import static org.assertj.core.api.BDDAssertions.then;

import com.example.cleanarchitecture.account.domain.AccountId;
import com.example.cleanarchitecture.account.domain.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SendMoneySystemTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    @Sql("classpath:SendMoneySystemTest.sql")
    void sendMoney() {

        Money initialSourceBalance = Money.of(500L);
        Money initialTargetBalance = Money.of(800L);

        ResponseEntity response = whenSendMoney(
            new AccountId(1L),
            new AccountId(2L),
            Money.of(500L));

        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private ResponseEntity whenSendMoney(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<Void> request = new HttpEntity<>(null, headers);

        return restTemplate.exchange(
            "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}",
            HttpMethod.POST,
            request,
            Object.class,
            sourceAccountId.getValue(),
            targetAccountId.getValue(),
            amount.getValue());
    }
}
