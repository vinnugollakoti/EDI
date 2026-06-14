package org.example.edi.dto;
import org.example.edi.tables.OrderItem;
import java.util.List;

public class CreateOrderRequest {

    private String poNumber;
    private List<OrderItemRequest> items;

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }
}
