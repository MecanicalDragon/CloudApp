package net.medrag.amqpsender;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit	//	required only for receiving messages
@SpringBootApplication
public class AmqpSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpSenderApplication.class, args);
	}

}
