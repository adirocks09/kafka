package com.arisglobal.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("state")
@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @GetMapping(value = "/send")
    public void producer() {
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
        System.out.println(12);
    }
}
