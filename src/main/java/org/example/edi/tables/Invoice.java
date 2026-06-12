package org.example.edi.tables;

//id
//        invoice_number
//order_id
//        total_amount
//created_at

public class Invoice {

    private Long id;
    private int invoiceNumber;
    private Long orderId;
    private int totalAmount;
    private String createdAt;

    public Invoice() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public Long getOrderId() {
        return orderId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
