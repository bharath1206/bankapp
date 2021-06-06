package com.demo.bankapp.producer;

import com.demo.bankapp.model.CustomerBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerBalanceProducer  {

    @Autowired
    private KafkaTemplate<String, CustomerBalance> kafkaTemplate;

    String kafkaTopic = "CustomerBalanceTopic";

    public void publish(CustomerBalance CustomerBalance) {

        kafkaTemplate.send(kafkaTopic, CustomerBalance);

    }



}
