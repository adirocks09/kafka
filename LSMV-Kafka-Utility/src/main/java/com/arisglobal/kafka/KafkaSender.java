package com.arisglobal.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    public static final String TENANT_ID = "tenantId";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.source.topic}")
    private String sourceTopic;

    public void send(String tenantId, Object message) {
        Message<Object> kafkaMsg = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, sourceTopic)
                .setHeader(TENANT_ID, tenantId)
                .build();
        kafkaTemplate.send(kafkaMsg);
    }
}
