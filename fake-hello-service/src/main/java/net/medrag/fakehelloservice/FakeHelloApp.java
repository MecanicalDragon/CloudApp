package net.medrag.fakehelloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * {@author} Stanislav Tretyakov
 * 06.02.2020
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class FakeHelloApp {
    public static void main(String[] args) {
        SpringApplication.run(FakeHelloApp.class, args);
    }

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }
}
