package com.demo.bankapp.repository;

import com.demo.bankapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {

    Customer findByAccountId(Long accountId);

}
