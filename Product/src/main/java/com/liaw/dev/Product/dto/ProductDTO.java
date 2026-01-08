package com.liaw.dev.Product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@NotBlank
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;

}
