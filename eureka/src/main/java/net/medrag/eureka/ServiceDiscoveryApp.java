package net.medrag.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * {@author} Stanislav Tretyakov
 * 06.02.2020
 */

@EnableEurekaServer
@SpringBootApplication
public class ServiceDiscoveryApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApp.class, args);
    }
}
