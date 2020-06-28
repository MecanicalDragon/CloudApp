package net.medrag.fakehelloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * {@author} Stanislav Tretyakov
 * 06.02.2020
 */
@SpringBootApplication
@ComponentScan("net.medrag")
public class FakeHelloApp {
    public static void main(String[] args) {
        SpringApplication.run(FakeHelloApp.class, args);
    }
}
