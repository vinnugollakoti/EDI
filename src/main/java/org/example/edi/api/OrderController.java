package org.example.edi.api;
import org.example.edi.dto.CreateOrderRequest;
import org.example.edi.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
