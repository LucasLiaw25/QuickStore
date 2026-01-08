package com.liaw.dev.Order.producer;

import com.liaw.dev.Order.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendOrder(OrderEvent event){
        System.out.println("Enviando pedido pro processamento");
        rabbitTemplate.convertAndSend("", "order-queue", event);
    }

}
