package com.arisglobal.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Profile("kafka")
@Service
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.target.topic}")
    private String targetTopic;

    @KafkaListener(topics = "${kafka.source.topic}", groupId = "${kafka.groupId}")
    public void listen (String message)
    {
        System.out.println("Listening message on port 6080 = " + message);
    }

    @KafkaListener(topics = "${kafka.source.topic}", groupId = "${kafka.groupId}")
    public void listen2 (String message)
    {
        System.out.println("Listening 2 message on port 6080 = " + message);
    }

    @KafkaListener(topics = "${kafka.source.topic}", groupId = "lsmv-2023")
    public void listenAgain (String message)
    {
        System.out.println("Listening message again on port 6080  = " + message);
        kafkaTemplate.send(targetTopic, message);
    }
}
