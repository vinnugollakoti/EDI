package org.example.edi.repository;

import org.example.edi.tables.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySku(String sku);

    Optional<Inventory> findBySku(String sku);

    String sku(String sku);
}
