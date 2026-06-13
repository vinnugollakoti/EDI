package org.example.edi.services;
import org.example.edi.enums.Status;
import org.example.edi.repository.OrderRepository;
import org.example.edi.tables.Order;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;


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
            if (!orderRepository.existsById(id)) {
                return "Order not found";
            }
            orderRepository.deleteById(id);
            return "Order cancelled successfully!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String modifyOrderStatus(int id, Status status) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

            order.setStatus(status);

            orderRepository.save(order);
            return "Order status updated!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Order getOrderById(int id) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

            return order;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
