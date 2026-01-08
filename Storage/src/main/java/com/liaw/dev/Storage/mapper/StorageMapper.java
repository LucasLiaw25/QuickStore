package com.liaw.dev.Storage.mapper;

import com.liaw.dev.Storage.dto.StorageDTO;
import com.liaw.dev.Storage.entity.Storage;
import org.springframework.stereotype.Component;

@Component
public class StorageMapper {

    public StorageDTO toDTO(Storage storage){
        return new StorageDTO(
                storage.getId(),
                storage.getProductId(),
                storage.getProductName(),
                storage.getProductPrice(),
                storage.getProductQuantity()
        );
    }

}
