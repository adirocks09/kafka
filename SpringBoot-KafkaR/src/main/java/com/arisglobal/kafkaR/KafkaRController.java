package com.arisglobal.kafkaR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaRController {

    @Autowired
    KafkaRSender kafkaSender;

    @GetMapping(value = "/publish/{message}")
    public String producer(@PathVariable String message) {
        kafkaSender.send(message);
        return "Message Published Successfully";
    }
}
