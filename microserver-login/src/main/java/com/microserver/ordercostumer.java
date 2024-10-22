package microserver-login.microserver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = "order_queue") // Debe coincidir con el nombre de la cola
    public void receiveOrder(String order) {
        System.out.println("Order received: " + order);
    }
}
