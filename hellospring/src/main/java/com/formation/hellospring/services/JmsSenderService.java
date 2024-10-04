package com.formation.hellospring.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsSenderService {

    private static Logger log = LoggerFactory.getLogger(JmsSenderService.class);

    @Autowired
    static
    JmsTemplate jmsTemplate;

    public static void sendMessage(String message) {
        log.info(String.format("Sending message: %s", message));
        jmsTemplate.convertAndSend("Q002", message);
    }
}
