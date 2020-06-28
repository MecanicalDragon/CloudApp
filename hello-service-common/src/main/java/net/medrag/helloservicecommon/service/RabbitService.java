package net.medrag.helloservicecommon.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Stanislav Tretyakov
 * 28.06.2020
 */
@Service
public class RabbitService {

    @RabbitListener(queues = "sample_queue")
    public void processMessage(String content) {
        System.out.println("NEW MESSAGE RECEIVED:");
        System.out.println(content);
    }
}
