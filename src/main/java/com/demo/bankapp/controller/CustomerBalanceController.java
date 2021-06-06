package com.demo.bankapp.controller;


import com.demo.bankapp.model.Balance;
import com.demo.bankapp.model.Customer;
import com.demo.bankapp.model.CustomerBalance;
import com.demo.bankapp.producer.CustomerBalanceProducer;
import com.demo.bankapp.repository.BalanceJpsRepository;
import com.demo.bankapp.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerBalanceController {

    @Autowired
    BalanceJpsRepository balanceJpsRepository;

    @Autowired
    CustomerJpaRepository customerJpaRepository;

    @Autowired
    CustomerBalanceProducer customerBalanceProducer;


    @GetMapping("/publish/{accountId}")
    public String send(@PathVariable("accountId") final Long accountId) {

        CustomerBalance customerBalance = new CustomerBalance();

        Balance balance = balanceJpsRepository.findByAccountId(accountId);
        customerBalance.setBalance(balance.getBalance());

        Customer customer = customerJpaRepository.findByAccountId(accountId);
        customerBalance.setAccountId(customer.getAccountId());
        customerBalance.setCustomerId(customer.getCustomerId());
        customerBalance.setPhoneNumber(customer.getPhoneNumber());

        customerBalanceProducer.publish(customerBalance);
        return "Published Successfully";

    }

}
