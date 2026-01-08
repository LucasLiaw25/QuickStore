package com.liaw.dev.Storage.controller;

import com.liaw.dev.Storage.dto.AddProductRequest;
import com.liaw.dev.Storage.dto.StorageDTO;
import com.liaw.dev.Storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/storage/")
public class StorageController {

    private final StorageService service;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody AddProductRequest request){
        service.addProduct(request);
        return ResponseEntity.ok("Produto adicionado ao estoque com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<StorageDTO>> listStorage(){
        return ResponseEntity.ok(service.listStorage());
    }

    @GetMapping("{id}")
    public ResponseEntity<StorageDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("product/{productId}")
    public ResponseEntity<StorageDTO> findByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(service.findByProductId(productId));
    }

}
