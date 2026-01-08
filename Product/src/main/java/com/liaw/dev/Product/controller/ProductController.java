package com.liaw.dev.Product.controller;


import com.liaw.dev.Product.dto.ProductDTO;
import com.liaw.dev.Product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/product/")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createProduct(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listProduct(){
        return ResponseEntity.ok(service.listProduct());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO dto){
        return ResponseEntity.ok(service.updateProduct(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
        return ResponseEntity.ok("Produto deletado com sucesso");
    }

}
