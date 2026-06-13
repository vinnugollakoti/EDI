package org.example.edi.api;
import org.example.edi.dto.OrderDto;
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
    public String createOrder(@RequestBody OrderDto request) {
        return orderService.createOrder(request.getPoNumber());
    }

    @PostMapping("/true")
    public OrderDto Testing(@RequestBody OrderDto request) {
        System.out.println(request.getId());
        System.out.println(request.getPoNumber());
        System.out.println(request.getStatus());

        return request;
    }
}
