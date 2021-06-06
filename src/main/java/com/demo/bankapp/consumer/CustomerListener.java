package com.demo.bankapp.consumer;

import com.demo.bankapp.model.Balance;
import com.demo.bankapp.model.Customer;
import com.demo.bankapp.repository.CustomerJpaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class CustomerListener {

    private static  final Logger logger = LoggerFactory.getLogger(CustomerListener.class);

    @Autowired
    CustomerJpaRepository customerJpaRepository;

    @KafkaListener(topics = "CustomerTopic", groupId = "group_customer",
            containerFactory = "customerKafkaListenerContainerFactory")
    public void consumeJson(Customer customer) {

        logger.info("Customer JSON Value : "+customer);

        customerJpaRepository.save(customer);
    }



}
