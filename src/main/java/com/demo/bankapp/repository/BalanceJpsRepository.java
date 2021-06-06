package com.demo.bankapp.repository;

import com.demo.bankapp.model.Balance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceJpsRepository extends JpaRepository<Balance, Long> {

    Balance findByAccountId(Long accountId);
}
