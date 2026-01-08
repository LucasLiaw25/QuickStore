package com.liaw.dev.Product.validator;


import com.liaw.dev.Product.entity.Product;
import com.liaw.dev.Product.exception.ProductNotFoundException;
import com.liaw.dev.Product.rapository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductValidator {

    private final com.liaw.dev.Product.rapository.ProductRepository repository;

    public void validateId(Long id){
        Optional<com.liaw.dev.Product.entity.Product> product = repository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException("Produto não encontrado");
        }
    }

}
