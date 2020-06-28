package net.medrag.helloservicecommon.configuration;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Stanislav Tretyakov
 * 28.06.2020
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableRabbit
@Configuration
public class CommonConfig {

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }
}
