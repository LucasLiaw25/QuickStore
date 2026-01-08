package com.liaw.dev.Storage.consumer;

import com.liaw.dev.Storage.dto.OrderEvent;
import com.liaw.dev.Storage.dto.StorageEvent;
import com.liaw.dev.Storage.entity.Storage;
import com.liaw.dev.Storage.repository.StorageRepository;
import exceptions.exception.StorageEndException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class StorageConsumer {

    private final StorageRepository repository;

    @RabbitListener(queues = "storage-queue")
    public void createStorage(@Payload StorageEvent event){
        System.out.println("Recebendo o produto no armazém");
        Storage storage = new Storage();
        storage.setProductName(event.getProductName());
        storage.setProductId(event.getProductId());
        storage.setProductPrice(event.getPrice());
        storage.setProductQuantity(0);
        repository.save(storage);
    }

    @RabbitListener(queues = "order-queue")
    public void handleOrder(@Payload OrderEvent event){
        Storage storage = repository.findByProductId(event.getProductId())
                .orElseThrow(()-> new RuntimeException("Produto não encontrado no estoque"));

        storage.setProductQuantity(storage.getProductQuantity() - event.getQuantity());
        repository.save(storage);
    }

}
