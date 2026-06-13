package org.example.edi.dto;

public class OrderItemDto {

    private Long id;
    private int orderId;
    private String sku;
    private int quantity;
    private int price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
