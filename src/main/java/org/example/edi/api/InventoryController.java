package org.example.edi.api;


import org.example.edi.dto.InventoryDto;
import org.example.edi.services.InventoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/")
    public String createInventory(@RequestBody InventoryDto request) {
        return inventoryService.createInventory(
                request.getSku(),
                request.getAvailableQuantity(),
                request.getReserveQuantity()
        );
    }


}
