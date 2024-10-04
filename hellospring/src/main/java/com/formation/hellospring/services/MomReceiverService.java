package com.formation.hellospring.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MomReceiverService {

    private static Logger log = LoggerFactory.getLogger(MomReceiverService.class);

    @JmsListener(containerFactory = "myFactory", destination = "Q002")
    public void receiveMessage(String message) {
        log.info(String.format("Message: %1$s", message));
    }

}
