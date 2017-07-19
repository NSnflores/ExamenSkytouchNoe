package nflores.examen;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class ExamenSender implements CommandLineRunner{
    @Value("${examen.client.times_to_send:1}")
    private int times;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... arg0) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        for(int i = 0; i < times; i++) {
            Person falsePerson = new Person("Noe", 11);
            String jsonPerson = objectMapper.writeValueAsString(falsePerson);
            template.convertAndSend(queue.getName(), jsonPerson);
            System.out.println("Sent: " + jsonPerson);
        }
        ctx.close();
    }
}