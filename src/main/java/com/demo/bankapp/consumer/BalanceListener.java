package com.demo.bankapp.consumer;

import com.demo.bankapp.model.Balance;
import com.demo.bankapp.repository.BalanceJpsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BalanceListener {

    private static  final Logger logger = LoggerFactory.getLogger(BalanceListener.class);

    @Autowired
    BalanceJpsRepository balanceJpsRepository;

    @KafkaListener(topics = "BalanceTopic", groupId = "group_balance",
            containerFactory = "balanceKafkaListenerContainerFactory")
    public void consumeJson(Balance balance) {

        logger.info("Balance JSON Value : "+balance);

        balanceJpsRepository.save(balance);
    }
}
