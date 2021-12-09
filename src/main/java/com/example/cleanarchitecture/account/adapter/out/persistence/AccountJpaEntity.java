package com.example.cleanarchitecture.account.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
@Entity
class AccountJpaEntity {

    @GeneratedValue
    @Id
    private Long id;

    private Long balance;
}
