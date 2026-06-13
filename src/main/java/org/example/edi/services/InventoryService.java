package org.example.edi.services;

import org.example.edi.repository.InventoryRepository;
import org.example.edi.tables.Inventory;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final InventoryRepository inventoryrepository;


    public InventoryService(InventoryRepository inventoryrepository) {
        this.inventoryrepository = inventoryrepository;
    }

    public String createInventory(String sku, int available_quantity, int reserved_quantity) {
        try {
            Inventory inventory = new Inventory();

            inventory.setSku(sku);
            inventory.setAvailableQuantity(available_quantity);
            inventory.setReservedQuantity(reserved_quantity);

            inventoryrepository.save(inventory);

            return "Inventory created";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String addAvailableQuantity(Long id, int quantity) {
        try {
            Inventory inventory = inventoryrepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
            inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);

            inventoryrepository.save(inventory);
            return "Inventory added ";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String addReservedQuantity(Long id, int quantity) {
        try {
            Inventory inventory = inventoryrepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));

            inventory.setReservedQuantity(inventory.getReservedQuantity() + quantity);

            inventoryrepository.save(inventory);
            return "Inventory updated successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String removeAvailableQuantity(Long id, int quantity) {
        try {
            Inventory inventory = inventoryrepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
            inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);

            inventoryrepository.save(inventory);
            return "Inventory updated successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String removeReservedQuantity(Long id, int quantity) {
        try {
            Inventory inventory = inventoryrepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
            inventory.setReservedQuantity(inventory.getReservedQuantity() - quantity);

            inventoryrepository.save(inventory);
            return "Inventory updated successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteInventory(Long id) {
        try {
            Inventory inventory = inventoryrepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
            inventoryrepository.delete(inventory);

            return "Inventory deleted successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
