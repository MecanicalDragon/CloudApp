package net.medrag.loadballancing.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * {@author} Stanislav Tretyakov
 * 07.02.2020
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getDefaultHello")
    @GetMapping("/getRemoteHello")
    public String getRemoteHello(){
        return restTemplate.getForObject("http://hello-service/hello", String.class);
    }

    public String getDefaultHello(){
        return "All services are unavailable, so this is default Hello message. Try again several minutes later";
    }

}
