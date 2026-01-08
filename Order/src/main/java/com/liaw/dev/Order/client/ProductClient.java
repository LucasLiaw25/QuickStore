package com.liaw.dev.Order.client;

import com.liaw.dev.Order.dto.ProductDTO;
import com.liaw.dev.Order.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductService", url = "http://localhost:8081/api/product")
public interface ProductClient {

    @GetMapping("/{productId}")
    ProductDTO findProductById(@PathVariable Long productId);

}
