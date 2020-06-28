package net.medrag.amqpsender.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Tretyakov
 * 28.06.2020
 */
@Component
public class ReceivingMessageService {

    @RabbitListener(queues = "sample_queue")
    public void processMessage(String content) {
        System.out.println("NEW MESSAGE RECEIVED:");
        System.out.println(content);
    }
}
