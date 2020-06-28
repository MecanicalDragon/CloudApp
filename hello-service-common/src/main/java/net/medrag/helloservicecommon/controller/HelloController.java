package net.medrag.helloservicecommon.controller;

import net.medrag.helloservicecommon.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * {@author} Stanislav Tretyakov
 * 05.02.2020
 */
@RestController
public class HelloController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping("/")
    public String ping(){
        System.out.println("ping");
        return "ping";
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        String requestURI = request.getRequestURL().toString();
        return "Request to " + requestURI + ": " + propertyService.getMessage();
    }
}
