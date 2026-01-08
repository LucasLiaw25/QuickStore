package com.liaw.dev.Order.client;

import com.liaw.dev.Order.dto.StorageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "StorageService", url = "http://localhost:8084/api/storage/")
public interface StorageClient {

    @GetMapping("product/{productId}")
    StorageDTO findStorageByProductId(@PathVariable Long productId);

}
