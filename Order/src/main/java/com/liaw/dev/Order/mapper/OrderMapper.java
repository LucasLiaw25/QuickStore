package com.liaw.dev.Order.mapper;

import com.liaw.dev.Order.dto.OrderDTO;
import com.liaw.dev.Order.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order){
        return new OrderDTO(
                order.getId(),
                order.getUserId(),
                order.getProductId(),
                order.getUserName(),
                order.getProductName(),
                order.getProductQuantity(),
                order.getTotalPrice()
        );
    }

}
