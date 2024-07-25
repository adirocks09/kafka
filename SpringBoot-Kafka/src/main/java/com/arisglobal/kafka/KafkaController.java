package com.arisglobal.kafka;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("kafka")
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/publish/{message}")
    public String producer(@PathVariable String message) {
        kafkaSender.send(message);
        return "Message Published Successfully";
    }

    @GetMapping(value = "/getData/{message}")
    public String getData(@PathVariable String message, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if(session != null){
            return message + " :: " + session.getId();
        }
        return "Null Session : getData";
    }

    @GetMapping(value = "/viewData/{message}")
    public String viewData(@PathVariable String message, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null){
            return message + " :: " + session.getId();
        }
        return "Null Session : viewData";
    }
}
