package com.arisglobal.state;

import org.springframework.statemachine.StateMachine;

public class CaseDistribution {

    private StateMachine<States, Events> stateMachine;
    private String receiptNo;

}
