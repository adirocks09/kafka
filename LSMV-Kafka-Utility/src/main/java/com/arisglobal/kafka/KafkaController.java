package com.arisglobal.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/publish/{tenantId}/{message}")
    public String producer(@PathVariable String tenantId, @PathVariable String message) {
        kafkaSender.send(tenantId, message);
        return "Message Published Successfully : " + message ;
    }
}
