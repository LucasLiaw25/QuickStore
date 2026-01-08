package com.liaw.dev.Storage.config;

import com.fasterxml.jackson.databind.ObjectMapper; // CERTIFIQUE-SE DE QUE É ESSE IMPORT
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitConfig {

    @Bean
    public Queue productQueue(){
        return new Queue("storage-queue", true);
    }

    @Bean
    public Queue orderQueue(){
        return new Queue("order-queue", true);
    }


    @Bean
    public MessageConverter messageConverter() {
        ObjectMapper mapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        return new Jackson2JsonMessageConverter(mapper);
    }
}
