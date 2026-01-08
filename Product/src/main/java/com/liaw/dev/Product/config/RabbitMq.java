package com.liaw.dev.Product.config;

import com.fasterxml.jackson.databind.ObjectMapper; // CERTIFIQUE-SE DE QUE É ESSE IMPORT
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMq {

    @Bean
    public MessageConverter messageConverter() {
        ObjectMapper mapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        return new Jackson2JsonMessageConverter(mapper);
    }
}
