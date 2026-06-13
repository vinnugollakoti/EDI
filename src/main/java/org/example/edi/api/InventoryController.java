package org.example.edi.api;


import org.example.edi.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/inventory")
public class InventoryController {

    private final OrderService orderService;

    public InventoryController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping("/")
//    public String createInventory(@RequestBody String ) {
//
//    }
}
