package com.liaw.dev.Product.service;

import com.liaw.dev.Product.dto.ProductDTO;
import com.liaw.dev.Product.dto.StorageEvent;
import com.liaw.dev.Product.entity.Product;
import com.liaw.dev.Product.mapper.ProductMapper;
import com.liaw.dev.Product.producer.ProductProducer;
import com.liaw.dev.Product.rapository.ProductRepository;
import com.liaw.dev.Product.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper mapper;
    private final ProductProducer producer;
    private final ProductValidator validator;
    private final ProductRepository repository;

    public ProductDTO createProduct(ProductDTO dto){
        Product product = mapper.toEntity(dto);
        repository.save(product);
        StorageEvent event = new StorageEvent(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
        producer.sendProduct(event);
        return mapper.toDTO(product);
    }

    public List<ProductDTO> listProduct(){
        List<Product> products = repository.findAll();
        return products.stream().map(mapper::toDTO).toList();
    }

    public ProductDTO findById(Long id){
        validator.validateId(id);
        Product product = repository.findById(id).get();
        return mapper.toDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO dto){
        validator.validateId(id);
        Product product = mapper.toEntity(dto);
        product.setId(id);
        repository.save(product);
        return mapper.toDTO(product);
    }

    public void deleteProduct(Long id){
        validator.validateId(id);
        repository.deleteById(id);
    }


}
