package com.liaw.dev.Product.rapository;

import com.liaw.dev.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
