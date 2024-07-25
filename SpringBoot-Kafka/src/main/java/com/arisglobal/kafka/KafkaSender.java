package com.arisglobal.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Profile("kafka")
@Service
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.source.topic}")
    private String sourceTopic;

    public void send(String message) {
        kafkaTemplate.send(sourceTopic, message);
    }
}
