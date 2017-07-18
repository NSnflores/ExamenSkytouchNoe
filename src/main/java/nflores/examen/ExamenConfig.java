package nflores.examen;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class ExamenConfig {

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
    public ExamenSender sender() {
        return new ExamenSender();
    }
}