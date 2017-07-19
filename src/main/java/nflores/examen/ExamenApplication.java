package nflores.examen;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ExamenApplication {
	@Bean
	public Queue hello() {
		return new Queue("hello");
	}

	@Profile("receiver")
	@Bean
	public ExamenReceiver receiver() {
		return new ExamenReceiver();
	}

	@Profile("sender")
	@Bean
	public CommandLineRunner sender() {
		return new ExamenSender();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExamenApplication.class, args);
	}
}
