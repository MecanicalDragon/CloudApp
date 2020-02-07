package net.medrag.loadballancing;

//import net.medrag.loadballancing.controller.HelloServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * {@author} Stanislav Tretyakov
 * 07.02.2020
 */
@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "hello-service", configuration = HelloServiceConfiguration.class)
public class LbApp {
    public static void main(String[] args) {
        SpringApplication.run(LbApp.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
