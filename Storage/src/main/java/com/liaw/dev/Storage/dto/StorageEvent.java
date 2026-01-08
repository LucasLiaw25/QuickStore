package com.liaw.dev.Storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageEvent {
    private Long productId;
    private String productName;
    private BigDecimal price;
}
