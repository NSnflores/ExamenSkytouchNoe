package nflores.examen;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import static java.awt.SystemColor.control;

@SpringBootApplication
public class ExamenApplication {

	@Bean
	public CommandLineRunner examen() {
		return new ExamenRunner();
	}

	public static boolean IsRunning = true;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExamenApplication.class, args);
	}
}
