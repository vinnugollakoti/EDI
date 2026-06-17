package org.example.edi.services;
import org.example.edi.dto.CreateOrderRequest;
import org.example.edi.dto.OrderItemRequest;
import org.example.edi.enums.Status;
import org.example.edi.repository.InventoryRepository;
import org.example.edi.repository.OrderItemRepository;
import org.example.edi.repository.OrderRepository;
import org.example.edi.tables.Order;
import org.example.edi.tables.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Objects;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;
    private final InventoryService inventoryService;
    private final OrderItemRepository orderItemRepository;
    private final InvoiceService invoiceService;

    public OrderService(OrderRepository orderRepository, InventoryRepository inventoryRepository, InventoryService inventoryService, OrderItemRepository orderItemRepository, InvoiceService invoiceService) {
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
        this.inventoryService = inventoryService;
        this.orderItemRepository = orderItemRepository;
        this.invoiceService = invoiceService;
    }

    public String createOrder(CreateOrderRequest request) {
        Order order = new Order();

        order.setPoNumber(request.getPoNumber());
        order.setStatus(Status.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> items = new ArrayList<>();
        int totalAmount = 0;

        for (OrderItemRequest itemRequest: request.getItems()) {

            OrderItem item = new OrderItem();

            String sku = itemRequest.getSku();
            int quantity = itemRequest.getQuantity();
            int price = itemRequest.getPrice();

            if (!inventoryRepository.existsBySku(sku)) {
                throw new IllegalArgumentException("SKU Not found");
            }

            inventoryService.removeAvailableQuantity(sku, quantity);

            item.setSku(sku);
            item.setQuantity(quantity);
            item.setPrice(price);
            totalAmount += price;

            item.setOrder(order);

            items.add(item);
        }
        order.setItems(items);
        order.setInvoice(invoiceService.createInvoice(order, totalAmount));

        orderRepository.save(order);
        return "Order Created Successfully!";
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public String cancelOrder(Long id) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found to cancel"));

            orderRepository.deleteById(id);
            return "Order cancelled successfully!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String cancelOrderByItems(Long id, String sku) {
        try {
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found to cancel"));

            List<OrderItem> items = order.getItems();

            for (OrderItem item: items) {
                if (Objects.equals(item.getSku(), sku)) {
                    orderItemRepository.delete(item);
                    items.remove(item);
                    inventoryService.addAvailableQuantity(item.getSku(), item.getQuantity());
                }
            }

            if (items.isEmpty()) {
                orderRepository.delete(order);
            }

            orderRepository.save(order);

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
            return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String cancelAllOrders() {
        try {
            orderRepository.deleteAll();

            return "All Orders deleted!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
