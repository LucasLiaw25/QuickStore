package com.liaw.dev.Storage.repository;

import com.liaw.dev.Storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<Storage, Long> {
    Optional<Storage> findByProductId(Long productId);
}
