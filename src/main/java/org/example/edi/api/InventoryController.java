package org.example.edi.api;


import org.example.edi.dto.InventoryDto;
import org.example.edi.dto.ManageInventoryRequest;
import org.example.edi.services.InventoryService;
import org.example.edi.tables.Inventory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/addinventory")
    public String createInventory(@RequestBody InventoryDto request) {
        return inventoryService.createInventory(
                request.getSku(),
                request.getAvailableQuantity(),
                request.getReserveQuantity()
        );
    }

    @GetMapping("/getinventory/{id}")
    public Inventory getInventory(@PathVariable @RequestBody Long id) {
        return inventoryService.getInventory(id);
    }

    @GetMapping("/getinventorybysku/{sku}")
    public Inventory getInventoryBySku(@PathVariable String sku) {
        return inventoryService.getInventoryBySku(sku);
    }

    @PutMapping("/manageinventory")
    public String manageInventory(@RequestBody ManageInventoryRequest request) {
        int value = inventoryService.manageAvailableQuantity(request.getSku(), request.getQuantity(), request.getAdd());

        return "Inventory changed to " + value;
    }

    @DeleteMapping("/deleteinventory/{sku}")
    public String deleteInventory(@PathVariable String sku) {
        return inventoryService.deleteInventory(sku);
    }

}
