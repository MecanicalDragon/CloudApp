package net.medrag.fakehelloservice.controller;

import net.medrag.fakehelloservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@author} Stanislav Tretyakov
 * 05.02.2020
 */
@RestController
public class HelloController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping("/")
    public String ping() {
        System.out.println("ping");
        return "ping";
    }

    @GetMapping("/hello")
    public String hello() {

        return "Request to fake-hello-service: " + propertyService.getMessage();
    }
}
