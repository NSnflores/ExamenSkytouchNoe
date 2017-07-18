package nflores.examen;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@RabbitListener(queues = "hello")
public class ExamenReceiver {

    @RabbitHandler
    public void receive(String in){
        System.out.println("reading");
        System.out.println(in);
        ObjectMapper mapper = new ObjectMapper();
        Person person = null;
        try {
            person = mapper.readValue(in, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(person);
        System.out.println(person.getName()+" - "+person.getAge());
    }
}
