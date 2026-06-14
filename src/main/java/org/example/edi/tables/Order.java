package org.example.edi.tables;
import org.example.edi.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String poNumber;

    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private List<OrderItem> items;

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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
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

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}