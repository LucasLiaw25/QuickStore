package com.liaw.dev.Product.mapper;

import com.liaw.dev.Product.dto.ProductDTO;
import com.liaw.dev.Product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public Product toEntity(ProductDTO product){
        return new Product(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

}
