package com.arisglobal.kafkaR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaRSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.source.topic}")
    private String sourceTopic;

    public void send(String message) {
        kafkaTemplate.send(sourceTopic, message);
    }
}
