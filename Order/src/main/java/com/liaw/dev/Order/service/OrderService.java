package com.liaw.dev.Order.service;

import com.liaw.dev.Order.client.ProductClient;
import com.liaw.dev.Order.client.StorageClient;
import com.liaw.dev.Order.client.UserClient;
import com.liaw.dev.Order.dto.*;
import com.liaw.dev.Order.entity.Order;
import com.liaw.dev.Order.exception.exception.StorageEndException;
import com.liaw.dev.Order.mapper.OrderMapper;
import com.liaw.dev.Order.producer.OrderProducer;
import com.liaw.dev.Order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper mapper;
    private final UserClient userClient;
    private final OrderProducer producer;
    private final OrderRepository repository;
    private final ProductClient productClient;
    private final StorageClient storageClient;

    @Transactional
    public OrderDTO createOrder(OrderRequest request){
        UserDTO user = userClient.findUserById(request.getUserId());
        ProductDTO product = productClient.findProductById(request.getProductId());
        StorageDTO storage = storageClient.findStorageByProductId(product.getId());

        Order order = new Order();
        order.setUserName(user.getName());
        order.setUserId(user.getId());
        order.setProductId(product.getId());
        order.setProductName(product.getName());
        order.setProductQuantity(request.getQuantity());
        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));
        order.setTotalPrice(totalPrice);

        if (order.getProductQuantity() > storage.getProductQuantity()){
            throw new StorageEndException("Estoque insuficiente para o pedido");
        }

        repository.save(order);
        OrderEvent event = new OrderEvent(
                order.getProductId(),
                order.getProductQuantity()
        );

        producer.sendOrder(event);
        return mapper.toDTO(order);
    }

}
