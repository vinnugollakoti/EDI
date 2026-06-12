package org.example.edi.tables;
import org.example.edi.enums.Status;

public class Order {
    private Long id;
    private String poNumber;
    private Status status;
    private String createdAt;

    public Order() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return this.id;
    }

    public String getPoNumber() {
        return this.poNumber;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}