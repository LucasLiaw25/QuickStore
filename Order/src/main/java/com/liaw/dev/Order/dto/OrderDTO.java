package com.liaw.dev.Order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private String userName;
    private String productName;
    private Integer productQuantity;
    private BigDecimal totalPrice;
}
