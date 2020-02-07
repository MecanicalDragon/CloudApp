package net.medrag.centralconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * {@author} Stanislav Tretyakov
 * 06.02.2020
 */
@EnableConfigServer
@SpringBootApplication
public class CentralConfApp {
    public static void main(String[] args) {
        SpringApplication.run(CentralConfApp.class, args);
    }
}
