package net.medrag.amqpsender.controller;

import net.medrag.amqpsender.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Stanislav Tretyakov
 * 28.06.2020
 */
@RestController
public class MainController {

    @Autowired
    private RabbitService rabbitService;

    @PostMapping("/postMessage")
    public String postMessage(@RequestParam String msg){
        return rabbitService.postMessage(msg);
    }
}
