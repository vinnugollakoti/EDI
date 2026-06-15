package org.example.edi.services;
import org.example.edi.dto.CreateOrderRequest;
import org.example.edi.dto.OrderItemRequest;
import org.example.edi.enums.Status;
import org.example.edi.repository.OrderRepository;
import org.example.edi.tables.Order;
import org.example.edi.tables.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String createOrder(CreateOrderRequest request) {
        Order order = new Order();

        order.setPoNumber(request.getPoNumber());
        order.setStatus(Status.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> items = new ArrayList<>();

        for (OrderItemRequest itemRequest: request.getItems()) {

            OrderItem item = new OrderItem();

            item.setSku(itemRequest.getSku());
            item.setQuantity(itemRequest.getQuantity());
            item.setPrice(itemRequest.getPrice());

            item.setOrder(order);

            items.add(item);
        }

        order.setItems(items);
        orderRepository.save(order);

        return "Order Created Successfully!";
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public String cancelOrder(Long id) {
        try {
            if (!orderRepository.existsById(id)) {
                return "Order not found";
            }
            orderRepository.deleteById(id);
            return "Order cancelled successfully!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String modifyOrderStatus(Long id, Status status) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

            order.setStatus(status);

            orderRepository.save(order);
            return "Order status updated to " + status;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Order getOrderById(Long id) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

            return order;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteAllOrders() {
        try {
            orderRepository.deleteAll();

            return "All Orders deleted!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteOrder(Long id) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found to delete"));
            orderRepository.delete(order);

            return "Order deleted succesfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
