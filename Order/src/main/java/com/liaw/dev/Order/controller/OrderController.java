package com.liaw.dev.Order.controller;

import com.liaw.dev.Order.dto.OrderDTO;
import com.liaw.dev.Order.dto.OrderRequest;
import com.liaw.dev.Order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/")
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createOrder(request));
    }

}
