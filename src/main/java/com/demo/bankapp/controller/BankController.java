package com.demo.bankapp.controller;


import com.demo.bankapp.model.Balance;
import com.demo.bankapp.model.Customer;
import com.demo.bankapp.repository.BalanceJpsRepository;
import com.demo.bankapp.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    @Autowired
    BalanceJpsRepository balanceJpsRepository;

    @Autowired
    CustomerJpaRepository customerJpaRepository;

    @PostMapping(value = "/load/balance")
    public Balance saveUsers(@RequestBody final Balance balance) {
        balanceJpsRepository.save(balance);
        return balanceJpsRepository.findByAccountId(balance.getAccountId());
    }

    @PostMapping(value = "/load/customer")
    public Customer saveUsers(@RequestBody final Customer customer) {
        customerJpaRepository.save(customer);
        return customerJpaRepository.findByAccountId(customer.getAccountId());
    }

    @GetMapping(value = "/customer/{accountId}")
    public Customer findCustomer(@PathVariable final Long accountId) {
        return customerJpaRepository.findByAccountId(accountId);
    }

    @GetMapping(value = "/balance/{accountId}")
    public Balance findBalance(@PathVariable final Long accountId) {
        return balanceJpsRepository.findByAccountId(accountId);
    }



}
