package org.example.edi.tables;
import org.example.edi.enums.Status;
import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String poNumber;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String createdAt;

    public Order() {}

    public void setId(int id) {
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

    public int getId() {
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