package net.medrag.fakehelloservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.medrag.fakehelloservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * {@author} Stanislav Tretyakov
 * 06.02.2020
 */
@RestController
public class CBController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getDefaultInfo")
    @GetMapping("/circuit")
    public String getSomeInfo() {
        return restTemplate.getForObject("http://localhost:1111/getSomeInfo", String.class);
    }

    public String getDefaultInfo() {
        return propertyService.getInfo();
    }

}
