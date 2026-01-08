package com.liaw.dev.Order.repository;

import com.liaw.dev.Order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
