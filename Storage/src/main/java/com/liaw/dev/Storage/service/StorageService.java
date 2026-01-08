package com.liaw.dev.Storage.service;

import com.liaw.dev.Storage.dto.AddProductRequest;
import com.liaw.dev.Storage.dto.StorageDTO;
import com.liaw.dev.Storage.entity.Storage;
import com.liaw.dev.Storage.mapper.StorageMapper;
import com.liaw.dev.Storage.repository.StorageRepository;
import exceptions.exception.StorageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageMapper mapper;
    private final StorageRepository repository;

    public void addProduct(AddProductRequest request){
        Storage storage = repository.findByProductId(request.getProductId())
                .orElseThrow(()-> new RuntimeException("Produto não encontrado no estoque"));
        storage.setProductQuantity(storage.getProductQuantity() + request.getQuantity());
        repository.save(storage);
    }

    public List<StorageDTO> listStorage(){
        List<Storage> storages = repository.findAll();
        return storages.stream().map(mapper::toDTO).toList();
    }

    public StorageDTO findById(Long id){
        Storage storage = repository.findById(id)
                .orElseThrow(()-> new StorageNotFoundException("Estoque não encontrado"));
        return mapper.toDTO(storage);
    }

    public StorageDTO findByProductId(Long productId){
        Storage storage = repository.findByProductId(productId)
                .orElseThrow(()-> new StorageNotFoundException("Estoque não encontrado"));
        return mapper.toDTO(storage);
    }

}
