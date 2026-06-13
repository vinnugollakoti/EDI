package org.example.edi.services;

import org.aspectj.weaver.ast.Or;
import org.example.edi.enums.Status;
import org.example.edi.repository.OrderRepository;
import org.example.edi.tables.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

//private int id;
//private String poNumber;
//private Status status;
//private String createdAt;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String createOrder(String poNumber) {
        Order order = new Order();

        order.setPoNumber(poNumber);
        order.setStatus(Status.PENDING);
        order.setCreatedAt(LocalDateTime.now().toString());

        orderRepository.save(order);

        return "Order Created Successfully!";
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public String cancelOrder(int id) {
        try {


            return "Order cancelled successfully!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
