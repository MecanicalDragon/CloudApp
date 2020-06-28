package net.medrag.amqpsender.service;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stanislav Tretyakov
 * 28.06.2020
 */
@Service
public class RabbitService {

    private final RabbitMessagingTemplate rabbit;

    @Autowired
    public RabbitService(RabbitMessagingTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public String postMessage(String msg){
        rabbit.convertAndSend("sample_exchanger", "sample", msg);
        return "OK";
    }
}
