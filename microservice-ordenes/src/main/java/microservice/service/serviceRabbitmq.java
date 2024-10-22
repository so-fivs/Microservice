package microservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import microservice.config;

@Service
public class OrderService {

    public static final String QUEUE_NAME = "ordersQueue";

    @Autowired
    public OrderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(String order) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, order);
        System.out.println("Order sent: " + order);
    }
}

