package org.example.edi.api;
import org.example.edi.dto.CreateOrderRequest;
import org.example.edi.dto.ModifyOrderRequest;
import org.example.edi.services.OrderService;
import org.example.edi.tables.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public String createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/getallorders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/cancelorder/{id}")
    public String cancelOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }

    @PutMapping("/updateorder")
    public String modifyOrder(@RequestBody ModifyOrderRequest request) {
        System.out.println("STATUS :"  + request.getStatus());
        return orderService.modifyOrderStatus(request.getId(), request.getStatus());
    }

    @GetMapping("/getorder/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/deleteallorders")
    public String deleteAllOrders() {
        return orderService.deleteAllOrders();
    }

    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
