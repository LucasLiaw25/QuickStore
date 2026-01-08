package com.liaw.dev.Product.producer;

import com.liaw.dev.Product.dto.StorageEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendProduct(StorageEvent event){
        System.out.println("Enviando o produto pro armazém");
        rabbitTemplate.convertAndSend("", "storage-queue", event);
    }

}
