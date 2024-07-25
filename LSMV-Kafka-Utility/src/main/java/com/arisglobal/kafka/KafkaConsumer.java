package com.arisglobal.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.target.topic}")
    private String targetTopic;

    @KafkaListener(topics = "${kafka.source.topic}", groupId = "${kafka.groupId}")
    public void listen (String message)
    {
        System.out.println("Listening message...  " + message);
        kafkaTemplate.send(targetTopic, message);
    }
}
