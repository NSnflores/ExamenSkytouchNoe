package nflores.examen;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import javax.annotation.PostConstruct;
import java.util.Scanner;


public class ExamenSender {
    @Value("${examen.client.times_to_send:1}")
    private int times;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @PostConstruct
    public void send() throws Exception{

        for(int i = 0; i < times; i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPerson = objectMapper.writeValueAsString(new Person("noe", 11));
            this.template.convertAndSend(queue.getName(), jsonPerson);
            System.out.println("Sent: " + jsonPerson);
        }
        ExamenApplication.IsRunning = false;
    }
}