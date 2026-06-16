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

    public Inventory getInventory(Long id) {
        try {
            return inventoryrepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Inventory getInventoryBySku(String sku) {
        try {
            return inventoryrepository.findBySku(sku).orElseThrow(() -> new RuntimeException("Inventory not found with that sku"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int manageAvailableQuantity(String sku, int quantity, boolean bool) {
        try {
            Inventory inventory = inventoryrepository.findBySku(sku).orElseThrow(() -> new RuntimeException("Inventory not found!"));

            if(bool) {
                inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
            } else {
                inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);
            }

            inventoryrepository.save(inventory);

            return inventory.getAvailableQuantity();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addAvailableQuantity(String sku, int quantity) {
        try {
            Inventory inventory = inventoryrepository.findBySku(sku).orElseThrow(() -> new RuntimeException("Inventory not found"));
            inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
            inventory.setReservedQuantity(inventory.getReservedQuantity() - quantity);

            inventoryrepository.save(inventory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void removeAvailableQuantity(String sku, int quantity) {
        try {
            Inventory inventory = inventoryrepository.findBySku(sku).orElseThrow(() -> new RuntimeException("Inventory not found"));
            inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);
            inventory.setReservedQuantity(inventory.getReservedQuantity() + quantity);

            inventoryrepository.save(inventory);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String deleteInventory(String sku) {
        try {
            Inventory inventory = inventoryrepository.findBySku(sku).orElseThrow(() -> new RuntimeException("Inventory not found"));
            inventoryrepository.delete(inventory);

            return "Inventory deleted successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}